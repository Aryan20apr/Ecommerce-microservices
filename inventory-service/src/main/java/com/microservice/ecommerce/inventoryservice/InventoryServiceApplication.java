package com.microservice.ecommerce.inventoryservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservice.ecommerce.inventoryservice.modals.Inventory;
import com.microservice.ecommerce.inventoryservice.repositories.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
		return args->{
		   Inventory inventory1= Inventory.builder()
					.skuCode("iphone_15_plus")
					.quantity(50)
					.build();
			Inventory inventory2= Inventory.builder().
									skuCode("samsung_galaxy_s22_ultra_pro_max")
									.quantity(0).build();
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
					
		};
	}

}
