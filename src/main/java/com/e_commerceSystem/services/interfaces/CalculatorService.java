package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.Order;

public interface CalculatorService {

    float calculatePrice(Order order);
}
