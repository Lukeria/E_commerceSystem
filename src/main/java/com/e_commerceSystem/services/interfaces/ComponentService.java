package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.Glass;
import com.e_commerceSystem.entities.components.GlassType;

import java.util.List;

public interface ComponentService {

    List<GlassType> getGlassTypeList();
}
