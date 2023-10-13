package com.microservice.ecommerce.inventoryservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ecommerce.inventoryservice.dtos.GeneralResponse;
import com.microservice.ecommerce.inventoryservice.services.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    
    private final InventoryService inventoryService;

    @GetMapping("/{skuCode}")
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse isInStock(@PathVariable("sku-code") String skuCode){
        boolean result=inventoryService.isInStock(skuCode);
            if(result==true)
            {
                return GeneralResponse.builder().availibility(result).message("Product with id "+skuCode+" is available.").build();
            }
            else
                return GeneralResponse.builder().availibility(result).message("Product with id "+skuCode+" is not available.").build();
    }
}
