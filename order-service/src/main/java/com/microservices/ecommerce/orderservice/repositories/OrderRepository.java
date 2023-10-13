package com.microservices.ecommerce.orderservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.ecommerce.orderservice.modals.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
    
}
