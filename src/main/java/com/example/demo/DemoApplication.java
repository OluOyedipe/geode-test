package com.example.demo;

import com.example.demo.domain.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.client.ClientCacheFactoryBean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableIndexing;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootApplication
@ClientCacheApplication
@EnableEntityDefinedRegions(basePackageClasses = Customer.class)
@EnableGemfireRepositories(basePackageClasses = CustomerRepository.class)
@EnableIndexing
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(CustomerRepository customerRepository) {
		return args -> {
			assertThat(customerRepository.count()).isEqualTo(0);
			Customer jonDoe = new Customer(1L, "Jon Doe");

			System.err.printf("Saving Customer [%s]...%n", jonDoe);

			jonDoe = customerRepository.save(jonDoe);
		};
	}
}
