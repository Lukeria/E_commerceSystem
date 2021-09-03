package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;

import java.util.List;

public interface ComponentService {

    List<GlassType> getGlassTypeList();
    void addGlassType(String name, Integer thickness);
    GlassType getGlassTypeById(Long id);
    void updateGlassType(GlassType glassType);
    void updateGlassTypePrices(GlassType glassType);
//    void deleteGlassType();

    List<Accessory> getAccessoryList();
    void addAccessory(String name);
    void updateAccessory(Accessory accessory);
    void updateAccessoryPrices(Accessory accessory);
//    void deleteAccessory();

    List<Processing> getProcessingList();
    void addProcessing(String name, String symbol);
    Processing getProcessingById(Long id);
    void updateProcessing(Processing processing);
    void updateProcessingPrices(Processing processing);
//    void deleteProcessing();

}
