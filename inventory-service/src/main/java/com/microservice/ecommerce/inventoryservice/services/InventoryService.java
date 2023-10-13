package com.microservice.ecommerce.inventoryservice.services;

public interface InventoryService {
    

    public boolean isInStock(String skuCode);
}
