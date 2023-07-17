package com.ordermanagement.orderprocessingservice.repository;

import com.ordermanagement.orderprocessingservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
