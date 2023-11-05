package com.ninos.service.order;

import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ninos.mapper.OrderMapper;
import com.ninos.model.dto.OrderDTO;
import com.ninos.model.entity.Order;
import com.ninos.repository.OrderRepository;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Override
    public Page<OrderDTO> findOrderByCustomerEmail(String email, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Order> ordersPage = orderRepository.findByCustomerEmail(email,pageRequest);
        return new PageImpl<>(ordersPage.getContent().stream().map(order -> orderMapper.entityToDto(order)).collect(Collectors.toList()),pageRequest, ordersPage.getTotalElements());
    }



}
