package com.ninos.service.order;

import org.springframework.data.domain.Page;

import com.ninos.model.dto.OrderDTO;

public interface OrderService {

    Page<OrderDTO> findOrderByCustomerEmail(String email, int page, int size);


}
