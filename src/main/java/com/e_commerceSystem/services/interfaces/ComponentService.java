package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.Glass;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.entities.components.Processing;

import java.util.List;

public interface ComponentService {

    List<GlassType> getGlassTypeList();
    void addGlassType(GlassType glassType);
    void updateGlassType(GlassType glassType);
    void deleteGlassType(GlassType glassType);

    List<Accessory> getAccessoryList();
    void addAccessory(Accessory accessory);
    void updateAccessory(Accessory accessory);
    void deleteAccessory(Accessory accessory);

    List<Processing> getProcessingList();
    void addProcessing(Processing processing);
    void updateProcessing(Processing processing);
    void deleteProcessing(Processing processing);

}
