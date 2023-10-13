package com.microservices.ecommerce.orderservice.controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.ecommerce.orderservice.dtos.GeneralResponse;
import com.microservices.ecommerce.orderservice.dtos.OrderRequest;
import com.microservices.ecommerce.orderservice.services.OrderService;
import com.microservices.ecommerce.orderservice.dtos.OrderResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderservice;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralResponse placeOrder(@RequestBody OrderRequest orderRequest) {
        orderservice.placeOrder(orderRequest);
        return GeneralResponse.builder().message("Order placed successfully").build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrders() {
        return orderservice.getAllOrders();
}
}
