package com.ordermanagement.orderservice.repository;

import com.ordermanagement.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
