package com.microservices.ecommerce.product.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.ecommerce.product.dtos.ProductRequest;
import com.microservices.ecommerce.product.dtos.ProductResponse;
import com.microservices.ecommerce.product.modal.Products;
import com.microservices.ecommerce.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ProductServiceImpl implements ProductService{

   private final ProductRepository productRepository;

  
    @Override
    public String createProduct(ProductRequest productRequest) {
       
        Products product=Products.builder()
        .description(productRequest
        .getDescription())
        .name(productRequest.getName())
        .price(productRequest.getPrice())
        .build();

        productRepository.save(product);
        log.info("Product {} is saved",product.getId());

        return "Product with id "+ product.getId()+" is saved successfully.";
    }


    @Override
    public List<ProductResponse> getAllProducts() {
        List<Products> products=productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();

    }
    
    @Override
    public String deleteProduct(String productId) {

        productRepository.deleteById(productId);
        return "Product with id "+productId+" is deleted";
    }
    @Override
    public String updateProduct(ProductRequest productRequest, String productId) {
        Products product=Products.builder()
        .description(productRequest
        .getDescription())
        .name(productRequest.getName())
        .price(productRequest.getPrice())
        .id(productId)
        .build();
        productRepository.save(product);
        return "Product with id "+productId+" updated successfully"; 
    }
   private ProductResponse mapToProductResponse(Products product)
   {
        return ProductResponse.builder()
                    .id(product.getId())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .name(product.getName()).build();
   }
   
}
