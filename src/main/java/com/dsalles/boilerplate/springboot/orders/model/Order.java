package com.dsalles.boilerplate.springboot.orders.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String name;

    private String description;

    @DBRef
    private List<OrderProduct> orderProducts;
}