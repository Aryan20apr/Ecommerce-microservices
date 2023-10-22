package com.microservice.ecommerce.inventoryservice.services;

import java.util.List;

import com.microservice.ecommerce.inventoryservice.dtos.InventoryResponse;

public interface InventoryService {
    

    public List<InventoryResponse> isInStock(List<String> skuCode) throws InterruptedException;
}
