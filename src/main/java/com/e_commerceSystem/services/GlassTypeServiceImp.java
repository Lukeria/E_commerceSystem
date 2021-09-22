package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.ComponentTypes;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.repositories.interfaces.ComponentDao;
import com.e_commerceSystem.services.interfaces.ComponentService;
import com.e_commerceSystem.services.interfaces.ComponentService_2_0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GlassTypeServiceImp implements ComponentService_2_0<GlassType> {

    @Autowired
    private ComponentDao componentDao;

    @Override
    public List<GlassType> getComponentList() {
        return componentDao.getGlassTypeAll();
    }

    @Override
    public void addComponent(GlassType component) {
        componentDao.addGlassType(component);
    }

    @Override
    public GlassType getComponentById(Long id) {
        return componentDao.getGlassTypeById(id);
    }

    @Override
    public void updateComponent(GlassType component) {
        componentDao.updateGlassType(component);
    }

    @Override
    public boolean canHandle(ComponentTypes componentTypes) {
        return componentTypes == ComponentTypes.GLASS_TYPE;
    }

}
