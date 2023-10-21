package com.microservice.ecommerce.inventoryservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.ecommerce.inventoryservice.modals.Inventory;


public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    
   

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
