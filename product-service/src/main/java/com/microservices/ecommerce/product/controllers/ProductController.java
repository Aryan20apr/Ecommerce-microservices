package com.microservices.ecommerce.product.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.ecommerce.product.dtos.GeneralResponse;
import com.microservices.ecommerce.product.dtos.ProductRequest;
import com.microservices.ecommerce.product.dtos.ProductResponse;
import com.microservices.ecommerce.product.services.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GeneralResponse createProduct(@RequestBody ProductRequest productRequest)
    {
         String message=productService.createProduct(productRequest);
         return  GeneralResponse.builder().message(message).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProducts()
    {
       return productService.getAllProducts();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse deleteProduct(@RequestParam String productId)
    {
       String message= productService.deleteProduct(productId);
        return  GeneralResponse.builder().message(message).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public GeneralResponse updateProduct(@RequestBody ProductRequest productRequest, @RequestParam String productId)
    {
      String message=  productService.updateProduct(productRequest, productId);
      return GeneralResponse.builder().message(message).build();
    }
}
