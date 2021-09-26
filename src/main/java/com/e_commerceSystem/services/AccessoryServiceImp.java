package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.ComponentTypes;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.DefaultComponent;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.exceptions.ComponentExtractionException;
import com.e_commerceSystem.repositories.interfaces.ComponentDao;
import com.e_commerceSystem.services.interfaces.ComponentService;
import com.e_commerceSystem.services.interfaces.ComponentService_2_0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AccessoryServiceImp implements ComponentService_2_0<Accessory> {

    @Autowired
    ComponentDao componentDao;

    @Override
    public List<Accessory> getComponentList() {
        return componentDao.getAccessoryAll();
    }

    @Override
    public void addComponent(Accessory component) {

        component.setPrice(0.0F);
        component.setPriceUSD(0.0F);
        componentDao.addAccessory(component);

    }

    @Override
    public Accessory getComponentById(Long id) {
        return componentDao.getAccessoryById(id);
    }

    @Override
    public void updateComponent(Accessory accessory) {
        componentDao.updateAccessory(accessory);
    }

    @Override
    public void deleteComponent(Accessory component) {
        componentDao.deleteAccessory(component);
    }

    @Override
    public void updateComponentPrices(Accessory accessory) {
        componentDao.updateAccessoryPrices(accessory);
    }

    @Override
    public boolean canHandle(ComponentTypes componentTypes) {
        return componentTypes == ComponentTypes.ACCESSORY;
    }

    @Override
    public Accessory getEmptyComponent() {
        return new Accessory();
    }

    @Override
    public DefaultComponent extractComponentFromRequest(Map<String, String> params) throws ComponentExtractionException {

        Accessory accessory = new Accessory();
        accessory.setName(params.get("name"));
        try {
            if(!params.get("id").isEmpty()) {
                accessory.setId(Long.parseLong(params.get("id")));
            }
        } catch (NumberFormatException exception){
            throw new ComponentExtractionException();
        }

        return accessory;
    }
}
