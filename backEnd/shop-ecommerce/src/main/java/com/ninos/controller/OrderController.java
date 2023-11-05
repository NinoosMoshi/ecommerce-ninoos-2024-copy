package com.ninos.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.model.dto.OrderDTO;
import com.ninos.service.order.OrderService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

   private final OrderService orderService;


   // http://localhost:8080/api/v1/orders/search?email=<customerEmail>
   @GetMapping("/search")
   public Page<OrderDTO> searchOrders(@RequestParam(name = "email", defaultValue = "") String email,
                                       @RequestParam(name = "page", defaultValue = "0") int page,
                                       @RequestParam(name = "size", defaultValue = "100") int size){
      return orderService.findOrderByCustomerEmail(email, page, size);
   }


    
}
