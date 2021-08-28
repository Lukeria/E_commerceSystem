package com.e_commerceSystem.services;

import com.e_commerceSystem.repositories.interfaces.ComponentDao;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.services.interfaces.CalculatorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class CalculatorServiceImp implements CalculatorService {

    @Autowired
    private ComponentDao componentDao;

    public float calculatePrice(Map<String,String> allParams){

        ObjectMapper objectMapper = new ObjectMapper();

        List<Glass> table = null;
        try {
            table = objectMapper.readValue(allParams.get("tableJSON"), new TypeReference<List<Glass>>(){});
        } catch (IOException e){
            e.printStackTrace();
        }

        return 5;
    }

}
