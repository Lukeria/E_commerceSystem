package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.enums.ComponentType;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.entities.components.Processing;
import com.e_commerceSystem.services.interfaces.PriceListService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PriceListServiceImp implements PriceListService {

    private final ComponentServiceFactory componentServiceFactory;

    @Autowired
    public PriceListServiceImp(ComponentServiceFactory componentServiceFactory) {
        this.componentServiceFactory = componentServiceFactory;
    }

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
            componentServiceFactory.getComponentService(ComponentType.GLASS_TYPE).updateComponentPrices(item);
        }
    }

    @Override
    public void updatePriceListProcessing(String tableJson) {

        ObjectMapper objectMapper = new ObjectMapper();

        List<Processing> table = null;
        try {
            table = objectMapper.readValue(tableJson, new TypeReference<List<Processing>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Processing item : table) {
            componentServiceFactory.getComponentService(ComponentType.PROCESSING).updateComponentPrices(item);
        }
    }

    @Override
    public void updatePriceListAccessory(String tableJson) {

        ObjectMapper objectMapper = new ObjectMapper();

        List<Accessory> table = null;
        try {
            table = objectMapper.readValue(tableJson, new TypeReference<List<Accessory>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Accessory item : table) {
            componentServiceFactory.getComponentService(ComponentType.ACCESSORY).updateComponentPrices(item);
        }
    }
}
