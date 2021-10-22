package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;

import java.util.List;
import java.util.Map;

public interface CalculatorService {

    float calculatePrice(Order order);
}
