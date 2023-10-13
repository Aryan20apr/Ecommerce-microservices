package com.microservices.ecommerce.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.microservices.ecommerce.product.modal.Products;

public interface ProductRepository extends MongoRepository<Products,String>
{

}