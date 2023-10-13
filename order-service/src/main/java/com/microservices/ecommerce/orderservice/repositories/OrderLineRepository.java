package com.microservices.ecommerce.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.ecommerce.orderservice.modals.OrderLineItems;

public interface OrderLineRepository extends JpaRepository<OrderLineItems,Long>{
    
}
