package com.microservices.ecommerce.orderservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    
    @Bean
    @LoadBalanced  //Add client side load balancing capabilities to WebClientBuilder
    public WebClient.Builder webClinet()
    {
        return WebClient.builder();
    }
}
