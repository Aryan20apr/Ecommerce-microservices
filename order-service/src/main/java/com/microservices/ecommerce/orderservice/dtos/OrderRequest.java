package com.microservices.ecommerce.orderservice.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {

   

    private List<OrderLineItemsDto> orderLineItems;

}
