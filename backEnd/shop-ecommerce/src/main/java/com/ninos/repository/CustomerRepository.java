package com.ninos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninos.model.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // select * from customer c where c.email = theEmail
    Customer findByEmail(String theEmail);

}
