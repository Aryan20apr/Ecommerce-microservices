package com.microservices.ecommerce.orderservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.ecommerce.orderservice.dtos.OrderLineItemResponseDto;
import com.microservices.ecommerce.orderservice.dtos.OrderLineItemsDto;
import com.microservices.ecommerce.orderservice.dtos.OrderRequest;
import com.microservices.ecommerce.orderservice.dtos.OrderResponse;
import com.microservices.ecommerce.orderservice.modals.Order;
import com.microservices.ecommerce.orderservice.modals.OrderLineItems;
import com.microservices.ecommerce.orderservice.repositories.OrderRepository;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        
        
       List<OrderLineItems> orderLineItems= orderRequest.getOrderLineItems()
       .stream()
       .map(this::mapFromDto).toList();
      Order order= Order.builder().orderNumber(UUID.randomUUID().toString()).orderLineItems(orderLineItems).build();
            orderRepository.save(order);
    }

    private OrderLineItems mapFromDto(OrderLineItemsDto orderLineItemsDto) {
      return  OrderLineItems.builder()
      .price(orderLineItemsDto.getPrice())
      .quantity(orderLineItemsDto.getQuantity())
      .skuCode(orderLineItemsDto.getSkuCode())
      .build();
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orders=orderRepository.findAll();
        return orders.stream().map(this::mapToDto).toList();
        
    }

    private OrderResponse mapToDto(Order order) {


        List<OrderLineItems> orderLineItems = order.getOrderLineItems();
        List<OrderLineItemResponseDto> orderLineItemResponseDtos=orderLineItems.stream().map(this::mapItemToDto).toList();
        return OrderResponse.builder()
        .id(order.getId())
        .orderNumber(order.getOrderNumber())
        .orderLineItems(orderLineItemResponseDtos)
        .build();
    }
    
    private OrderLineItemResponseDto mapItemToDto(OrderLineItems orderLineItems) {
        return OrderLineItemResponseDto.builder()
        .id(orderLineItems.getId())
        .skuCode(orderLineItems.getSkuCode())
        .price(orderLineItems.getPrice())
        .quantity(orderLineItems.getQuantity())
        .build();
    }


}
