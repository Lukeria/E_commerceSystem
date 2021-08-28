package com.e_commerceSystem.services;

import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.entities.components.Processing;
import com.e_commerceSystem.repositories.interfaces.ComponentDao;
import com.e_commerceSystem.entities.Glass;
import com.e_commerceSystem.services.interfaces.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComponentServiceImp implements ComponentService {

    @Autowired
    ComponentDao componentDao;

    @Override
    public List<GlassType> getGlassTypeList() {
        return componentDao.getGlassTypeAll();
    }

    @Override
    public void addGlassType(GlassType glassType) {
        componentDao.addGlassType(glassType);
    }

    @Override
    public void updateGlassType(GlassType glassType) {
        componentDao.updateGlassType(glassType);
    }

    @Override
    public void deleteGlassType(GlassType glassType) {
        componentDao.deleteGlassType(glassType);
    }

    @Override
    public List<Accessory> getAccessoryList() {
        return componentDao.getAccessoryAll();
    }

    @Override
    public void addAccessory(Accessory accessory) {
        componentDao.addAccessory(accessory);
    }

    @Override
    public void updateAccessory(Accessory accessory) {
        componentDao.updateAccessory(accessory);
    }

    @Override
    public void deleteAccessory(Accessory accessory) {
        componentDao.deleteAccessory(accessory);
    }

    @Override
    public List<Processing> getProcessingList() {
        return componentDao.getProcessingAll();
    }

    @Override
    public void addProcessing(Processing processing) {
        componentDao.addProcessing(processing);
    }

    @Override
    public void updateProcessing(Processing processing) {
        componentDao.updateProcessing(processing);
    }

    @Override
    public void deleteProcessing(Processing processing) {
        componentDao.deleteProcessing(processing);
    }
}
