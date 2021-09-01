package com.e_commerceSystem.services;

import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.services.interfaces.ComponentService;
import com.e_commerceSystem.services.interfaces.PriceListService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PriceListServiceImp implements PriceListService {

    @Autowired
    private ComponentService componentService;

    @Override
    public void updatePriceListGlassType(String tableJson) {

        ObjectMapper objectMapper = new ObjectMapper();

        List<GlassType> table = null;
        try {
            table = objectMapper.readValue(tableJson, new TypeReference<List<GlassType>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (GlassType item : table) {
            componentService.updateGlassTypePrices(item);
        }
    }

    @Override
    public void updatePriceListProcessing(String tableJson) {

    }

    @Override
    public void updatePriceListAccessory(String tableJson) {

    }
}
