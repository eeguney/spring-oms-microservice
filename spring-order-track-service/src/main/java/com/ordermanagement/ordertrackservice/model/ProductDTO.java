package com.ordermanagement.ordertrackservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String productId;

    private String productTitle;

    private String brandName;

    private Double price;

    private Integer amount;
}
