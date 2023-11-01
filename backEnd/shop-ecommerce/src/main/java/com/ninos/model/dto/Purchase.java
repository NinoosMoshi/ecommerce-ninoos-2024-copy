package com.ninos.model.dto;

import lombok.Data;

import java.util.Set;

import com.ninos.model.entity.Address;
import com.ninos.model.entity.Customer;
import com.ninos.model.entity.Order;
import com.ninos.model.entity.OrderItem;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
