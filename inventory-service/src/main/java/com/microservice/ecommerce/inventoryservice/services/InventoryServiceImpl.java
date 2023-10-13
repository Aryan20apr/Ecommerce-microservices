package com.microservice.ecommerce.inventoryservice.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.ecommerce.inventoryservice.repositories.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {

        return inventoryRepository.findBySkuCode(skuCode).isPresent();

    }
}
