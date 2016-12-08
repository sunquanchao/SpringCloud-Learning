package com.didispace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker //使用@EnableCircuitBreaker注解开启断路器功能
@EnableDiscoveryClient
@SpringBootApplication
public class RibbonConsumerApplication {

	@Bean
	@LoadBalanced //通过@LoadBalanced注解开启均衡负载能力.
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(RibbonConsumerApplication.class, args);
	}

}
