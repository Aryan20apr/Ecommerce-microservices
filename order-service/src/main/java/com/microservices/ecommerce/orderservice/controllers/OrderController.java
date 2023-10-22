package com.microservices.ecommerce.orderservice.controllers;


import java.util.List;
import java.util.concurrent.CompletableFuture;

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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

import com.microservices.ecommerce.orderservice.dtos.OrderResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderservice;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory",fallbackMethod = "fallback")
    @TimeLimiter(name = "inventory")
    public CompletableFuture<GeneralResponse> placeOrder(@RequestBody OrderRequest orderRequest) {
      return  CompletableFuture.supplyAsync(()->orderservice.placeOrder(orderRequest));

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrders() {
        return orderservice.getAllOrders();
}

public CompletableFuture<GeneralResponse> fallback(OrderRequest orderRequest,RuntimeException runtimeException)
{
   return CompletableFuture.supplyAsync(()->GeneralResponse.builder().message(
        "There was a problem with the inventory service: "+runtimeException.getMessage()).build());
    
}

}
