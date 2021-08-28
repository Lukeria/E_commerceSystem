package com.e_commerceSystem.services;

import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.repositories.interfaces.ComponentDao;
import com.e_commerceSystem.entities.Glass;
import com.e_commerceSystem.services.interfaces.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentServiceImp implements ComponentService {

    @Autowired
    ComponentDao componentDao;

    @Override
    public List<GlassType> getGlassTypeList() {
        return componentDao.getGlassTypeAll();
    }
}
