package com.microservice.ecommerce.inventoryservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.ecommerce.inventoryservice.dtos.InventoryResponse;
import com.microservice.ecommerce.inventoryservice.repositories.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;
    Logger logger=LoggerFactory.getLogger(InventoryServiceImpl.class);
    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) throws InterruptedException {
        
        log.info("Wait started");
        Thread.sleep(10000);
        log.info("Wait Ended");

        logger.info("List of SKUcodes obtained are "+skuCode.toString());
        return inventoryRepository
        .findBySkuCodeIn(skuCode)
        .stream()
        .map(inventory->InventoryResponse
        .builder()
        .skuCode(inventory.getSkuCode())
        .isInStock(inventory.getQuantity()>0)
        .build())
        .toList();

    }
}
