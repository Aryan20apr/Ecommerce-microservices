package com.microservice.ecommerce.inventoryservice.dtos;

import lombok.Builder;

@Builder
public class GeneralResponse {
    
    String message;
    boolean availibility;
}
