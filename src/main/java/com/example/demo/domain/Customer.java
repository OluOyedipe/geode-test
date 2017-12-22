package com.example.demo.domain;

import org.springframework.data.gemfire.mapping.annotation.Indexed;
import org.springframework.data.gemfire.mapping.annotation.Region;

/**
 * @author Olu Oyedipe
 * @since 2017-12-21.
 */
@Region("Customers")
public class Customer {
    Long id;

    @Indexed(from = "/Customers")
    String name;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
