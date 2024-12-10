package com.dsalles.boilerplate.springboot.orders.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order_products")
public class OrderProduct {

    @Id
    private String id;

    @DBRef
    private Order order;

    @DBRef
    private Product product;

    private int quantity;
}