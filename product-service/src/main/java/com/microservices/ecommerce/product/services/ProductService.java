package com.microservices.ecommerce.product.services;

import java.util.List;

import com.microservices.ecommerce.product.dtos.ProductRequest;
import com.microservices.ecommerce.product.dtos.ProductResponse;

public interface ProductService {
    
    public String createProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();

    public String deleteProduct(String productId);

    public String updateProduct(ProductRequest productRequest, String productId);
}
