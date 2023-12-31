package com.ninos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ninos.model.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

//    Page<Order> findByCustomerEmail(@Param("email") String email, Pageable pageable);
    Page<Order> findByCustomerEmailOrderByDateCreatedDesc(@Param("email") String email, Pageable pageable);

}
