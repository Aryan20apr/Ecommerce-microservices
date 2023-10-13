package com.microservice.ecommerce.inventoryservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.ecommerce.inventoryservice.modals.Inventory;
import java.util.Optional;


public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    
    Optional<Inventory> findBySkuCode(String skuCode);
}
