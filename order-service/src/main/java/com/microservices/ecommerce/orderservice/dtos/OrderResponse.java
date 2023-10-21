package com.microservices.ecommerce.orderservice.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
    

    private Long id;
    private String orderNumber;

    
    private List<OrderLineItemResponseDto> orderLineItems;
}
