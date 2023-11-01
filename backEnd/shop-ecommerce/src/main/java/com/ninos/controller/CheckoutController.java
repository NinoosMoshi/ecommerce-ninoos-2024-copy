package com.ninos.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninos.model.dto.Purchase;
import com.ninos.model.dto.PurchaseResponse;
import com.ninos.service.checkout.CheckoutService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        return checkoutService.placeOrder(purchase);
    }


}
