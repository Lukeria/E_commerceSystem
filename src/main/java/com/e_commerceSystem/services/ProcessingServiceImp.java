package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.ComponentTypes;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.repositories.interfaces.ComponentDao;
import com.e_commerceSystem.services.interfaces.ComponentService_2_0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessingServiceImp implements ComponentService_2_0<Processing> {

    @Autowired
    private ComponentDao componentDao;

    @Override
    public List<Processing> getComponentList() {
        return componentDao.getProcessingAll();
    }

    @Override
    public void addComponent(Processing component) {
        componentDao.addProcessing(component);
    }

    @Override
    public Processing getComponentById(Long id) {
        return componentDao.getProcessingById(id);
    }

    @Override
    public void updateComponent(Processing component) {
        componentDao.updateProcessing(component);
    }

    @Override
    public boolean canHandle(ComponentTypes componentTypes) {
        return componentTypes == ComponentTypes.PROCESSING;
    }
}
