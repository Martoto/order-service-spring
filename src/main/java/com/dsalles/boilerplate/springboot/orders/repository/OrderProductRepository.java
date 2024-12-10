package com.dsalles.boilerplate.springboot.orders.repository;

import com.dsalles.boilerplate.springboot.orders.model.OrderProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderProductRepository extends MongoRepository<OrderProduct, String> {

}
