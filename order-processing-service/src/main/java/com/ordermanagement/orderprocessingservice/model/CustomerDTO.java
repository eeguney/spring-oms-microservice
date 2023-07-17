package com.ordermanagement.orderprocessingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long customerId;

    private String username;

    private String email;
}