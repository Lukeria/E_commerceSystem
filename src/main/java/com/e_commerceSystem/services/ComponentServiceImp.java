package com.e_commerceSystem.services;

import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.repositories.interfaces.ComponentDao;
import com.e_commerceSystem.services.interfaces.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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
    public void addGlassType(String name, Integer thickness) {
        GlassType glassType = new GlassType();
        glassType.setName(name);
        glassType.setThickness(thickness);
        componentDao.addGlassType(glassType);
    }

//    @Override
//    public void updateGlassType() {
//        componentDao.updateGlassType(glassType);
//    }
//
//    @Override
//    public void deleteGlassType() {
//        componentDao.deleteGlassType(glassType);
//    }

    @Override
    public List<Accessory> getAccessoryList() {
        return componentDao.getAccessoryAll();
    }

    @Override
    public void addAccessory(String name) {

        Accessory accessory = new Accessory();
        accessory.setName(name);
        componentDao.addAccessory(accessory);
    }

//    @Override
//    public void updateAccessory(Accessory accessory) {
//        componentDao.updateAccessory(accessory);
//    }
//
//    @Override
//    public void deleteAccessory(Accessory accessory) {
//        componentDao.deleteAccessory(accessory);
//    }

    @Override
    public List<Processing> getProcessingList() {
        return componentDao.getProcessingAll();
    }

    @Override
    public void addProcessing(String name, String symbol) {
        Processing processing = new Processing();
        processing.setName(name);
        processing.setSymbol(symbol);
        componentDao.addProcessing(processing);
    }

//    @Override
//    public void updateProcessing(Processing processing) {
//        componentDao.updateProcessing(processing);
//    }
//
//    @Override
//    public void deleteProcessing(Processing processing) {
//        componentDao.deleteProcessing(processing);
//    }
}
