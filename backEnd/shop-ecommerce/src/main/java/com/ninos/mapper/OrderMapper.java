package com.ninos.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ninos.model.dto.OrderDTO;
import com.ninos.model.entity.Order;

@Service
public class OrderMapper {

    public Order dtoToEntity(OrderDTO orderDTO){
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        return order;
    }


    public OrderDTO entityToDto(Order order){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order, orderDTO);
        return orderDTO;
    }


}
