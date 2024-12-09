package com.dsalles.boilerplate.springboot.orders.repository;

import com.dsalles.boilerplate.springboot.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}