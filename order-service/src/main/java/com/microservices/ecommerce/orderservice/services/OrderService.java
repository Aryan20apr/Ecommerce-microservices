package com.microservices.ecommerce.orderservice.services;

import java.util.List;

import com.microservices.ecommerce.orderservice.dtos.OrderRequest;
import com.microservices.ecommerce.orderservice.dtos.OrderResponse;

public interface OrderService {
    
    public void placeOrder(OrderRequest orderRequest);

    public List<OrderResponse> getAllOrders();
}
