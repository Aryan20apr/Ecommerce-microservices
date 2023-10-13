package com.microservices.ecommerce.orderservice.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderLineItemsDto {
    

    
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
