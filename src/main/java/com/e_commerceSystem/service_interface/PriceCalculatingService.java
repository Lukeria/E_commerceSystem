package com.e_commerceSystem.service_interface;

import java.util.Map;

public interface PriceCalculatingService {

    float calculatePrice(Map<String,String> allParams);
}
