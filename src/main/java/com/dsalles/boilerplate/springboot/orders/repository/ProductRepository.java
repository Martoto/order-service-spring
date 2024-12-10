package com.dsalles.boilerplate.springboot.orders.repository;

import com.dsalles.boilerplate.springboot.orders.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}