package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.entities.components.Processing;

import java.util.List;

public interface ComponentDao {

    List<GlassType> getGlassTypeAll();
    GlassType getGlassTypeById(Long id);
    void addGlassType(GlassType glassType);
    void updateGlassType(GlassType glassType);
    void updateGlassTypePrices(GlassType glassType);
    void deleteGlassType(GlassType glassType);

    List<Accessory> getAccessoryAll();
    Accessory getAccessoryById(Long id);
    void addAccessory(Accessory accessory);
    void updateAccessory(Accessory accessory);
    void updateAccessoryPrices(Accessory accessory);
    void deleteAccessory(Accessory accessory);

    List<Processing> getProcessingAll();
    Processing getProcessingById(Long id);
    void addProcessing(Processing processing);
    void updateProcessing(Processing processing);
    void updateProcessingPrices(Processing processing);
    void deleteProcessing(Processing processing);

//    List<AdditionalService> getAdditionalServiceAll();
}
