package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.enums.ComponentType;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.services.interfaces.CalculatorService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CalculatorServiceImp implements CalculatorService {

    @Autowired
    private ComponentServiceFactory componentServiceFactory;

    public float calculatePrice(String tableJson) {

        ObjectMapper objectMapper = new ObjectMapper();

        List<Glass> table = null;
        try {
            table = objectMapper.readValue(tableJson, new TypeReference<List<Glass>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        float price = 0;
        for (Glass glass : table) {
            float square = (float) (glass.getHeight() * glass.getWidth() / 1000000.);
            float perimeter = (float) ((glass.getHeight() + glass.getWidth()) / 1000. * 2);

            GlassType glassType = (GlassType) componentServiceFactory.getComponentService(ComponentType.GLASS_TYPE).getComponentById(glass.getGlassType().getId());
            price = square * glassType.getPrice();
            for (Processing currentProcessing : glass.getProcessingArrayList()) {

                Processing processing = (Processing) componentServiceFactory.getComponentService(ComponentType.PROCESSING).getComponentById(currentProcessing.getId());
                price += processing.getPrice() * perimeter * (currentProcessing.getQuantity() != 0 ? currentProcessing.getQuantity() : 1);
            }
        }

        return Math.round(price);
    }

    @Override
    public float calculatePrice(List<Glass> glassList) {

        float price = 0;

        for (Glass glass : glassList) {
            float square = (float) (glass.getHeight() * glass.getWidth() / 1000000.);
            float perimeter = (float) ((glass.getHeight() + glass.getWidth()) / 1000. * 2);

            GlassType glassType = (GlassType) componentServiceFactory.getComponentService(ComponentType.GLASS_TYPE).getComponentById(glass.getGlassType().getId());
            price += square * glassType.getPrice();
            for (Processing currentProcessing : glass.getProcessingList()) {

                Processing processing = (Processing) componentServiceFactory.getComponentService(ComponentType.PROCESSING).getComponentById(currentProcessing.getId());
                price += processing.getPrice() * perimeter * (currentProcessing.getQuantity() != 0 ? currentProcessing.getQuantity() : 1);
            }
        }

        return Math.round(price);
    }
}
