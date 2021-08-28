package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.entities.components.Processing;

import java.util.List;

public interface ComponentDao {

    List<GlassType> getGlassTypeAll();
    List<Accessory> getAccessoryAll();
    List<Processing> getProcessingAll();
//    List<AdditionalService> getAdditionalServiceAll();
}
