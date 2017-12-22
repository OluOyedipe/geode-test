package com.example.demo.repositories;

import com.example.demo.domain.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Olu Oyedipe
 * @since 2017-12-21.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
