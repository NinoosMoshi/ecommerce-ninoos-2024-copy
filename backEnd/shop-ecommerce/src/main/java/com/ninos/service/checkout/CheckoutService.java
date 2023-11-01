package com.ninos.service.checkout;

import com.ninos.model.dto.Purchase;
import com.ninos.model.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
