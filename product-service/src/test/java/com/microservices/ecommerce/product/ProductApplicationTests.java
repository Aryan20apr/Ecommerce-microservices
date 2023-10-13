package com.microservices.ecommerce.product;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.ecommerce.product.dtos.ProductRequest;
import com.microservices.ecommerce.product.repository.ProductRepository;
import com.mongodb.assertions.Assertions;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc // Needed for autowiring
class ProductApplicationTests {

	@Container // JUnit5 understands that this is a MongoDb Container
	static MongoDBContainer mongoDBContainer= new MongoDBContainer("mongo:4.4.2");
	// Test will download Mongo Db container by downloading the specified image

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper; // Map POJO to JSON and vice versa

	@Autowired
	private ProductRepository productRepository;
	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry)
	{
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception
	{
		ProductRequest productRequest= getProductRequest();
		String productRequestJson=objectMapper.writeValueAsString(productRequest);
		// We use mock mvc objects as it creates mock servlet environment to acess the controllers
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
		.contentType(MediaType.APPLICATION_JSON)
		.content(productRequestJson))
		.andExpect(status().isCreated());
		Assertions.assertTrue(productRepository.findAll().size()==1); //cHECK 

	}

	private  ProductRequest getProductRequest() 
	{
		return ProductRequest.builder()
		.name("Samsung Galaxy S22+")
		.description("Flagship phone from Samsung")
		.price(BigDecimal.valueOf(1300000))
		.build();
	}


	// Write other tests for other endpoints

}

	
