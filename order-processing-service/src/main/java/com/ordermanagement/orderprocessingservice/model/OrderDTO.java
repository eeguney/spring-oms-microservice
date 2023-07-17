package com.ordermanagement.orderprocessingservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class OrderDTO {

    private String orderId;

    private String customerId;

    private List<ProductDTO> products;

    private Integer totalPrice;

    private Enum orderStatus;

    private Date orderDate;


}
