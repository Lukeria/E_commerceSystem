package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;

import java.util.List;

public interface ComponentService {

    List<GlassType> getGlassTypeList();
    void addGlassType(String name, Integer thickness);
//    void updateGlassType();
//    void deleteGlassType();

    List<Accessory> getAccessoryList();
    void addAccessory(String name);
//    void updateAccessory();
//    void deleteAccessory();

    List<Processing> getProcessingList();
    void addProcessing(String name, String symbol);
//    void updateProcessing();
//    void deleteProcessing();

}
