package com.e_commerceSystem.services;

import com.e_commerceSystem.service_interface.PriceCalculatingService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PriceCalculatingServiceImp implements PriceCalculatingService {

    public float calculatePrice(Map<String,String> allParams){



        return 5;
    }

}
