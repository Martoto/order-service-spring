package com.dsalles.boilerplate.springboot.orders.service;

import com.dsalles.boilerplate.springboot.orders.dto.OrderDTO;
import com.dsalles.boilerplate.springboot.orders.dto.OrderProductDTO;
import com.dsalles.boilerplate.springboot.orders.exceptions.OrderNotFoundException;
import com.dsalles.boilerplate.springboot.orders.exceptions.ProductNotFoundException;
import com.dsalles.boilerplate.springboot.orders.model.Order;
import com.dsalles.boilerplate.springboot.orders.model.OrderProduct;
import com.dsalles.boilerplate.springboot.orders.model.Product;
import com.dsalles.boilerplate.springboot.orders.repository.OrderProductRepository;
import com.dsalles.boilerplate.springboot.orders.repository.OrderRepository;
import com.dsalles.boilerplate.springboot.orders.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Transactional
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO getOrderById(String id) {
        return orderRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }

    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setName(orderDTO.name());
        order.setDescription(orderDTO.description());
        order.setOrderProducts(orderDTO.orderProducts().stream()
                .map(op -> convertToEntity(op, order))
                .collect(Collectors.toList()));

        orderProductRepository.saveAll(order.getOrderProducts());
        Order savedOrder = orderRepository.save(order);
        return convertToDTO(savedOrder);
    }

    public OrderDTO updateOrder(String id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
        order.setName(orderDTO.name());
        order.setDescription(orderDTO.description());
        order.setOrderProducts(orderDTO.orderProducts().stream()
                .map(op -> convertToEntity(op, order))
                .collect(Collectors.toList()));

        orderProductRepository.saveAll(order.getOrderProducts());
        Order updatedOrder = orderRepository.save(order);
        return convertToDTO(updatedOrder);
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    private OrderDTO convertToDTO(Order order) {
        List<OrderProductDTO> orderProductDTOs = order.getOrderProducts().stream()
                .filter(Objects::nonNull)
                .map(orderProduct -> new OrderProductDTO(orderProduct.getProduct().getId(),  orderProduct.getQuantity()))
                .collect(Collectors.toList());
        BigDecimal value = order.getOrderProducts().stream()
                .filter(Objects::nonNull)
                .map(orderProduct -> orderProduct.getProduct().getPrice().multiply(new BigDecimal(orderProduct.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new OrderDTO(order.getId(), order.getName(), order.getDescription(), value, orderProductDTOs);
    }

    private OrderProduct convertToEntity(OrderProductDTO orderProductDTO, Order order) {
        Product product = productRepository.findById(orderProductDTO.productId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        return OrderProduct.builder()
                .order(order)
                .product(product)
                .quantity(orderProductDTO.quantity())
                .build();
    }
}