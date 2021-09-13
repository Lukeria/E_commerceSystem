package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.glass.Glass;

import java.util.List;
import java.util.Map;

public interface CalculatorService {

    float calculatePrice(String tableJson);
    float calculatePrice(List<Glass> glassList);
}
