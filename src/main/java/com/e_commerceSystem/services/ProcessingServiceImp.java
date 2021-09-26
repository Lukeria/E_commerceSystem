package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.ComponentTypes;
import com.e_commerceSystem.additional.ProcessingType;
import com.e_commerceSystem.entities.components.DefaultComponent;
import com.e_commerceSystem.entities.glass.Processing;
import com.e_commerceSystem.exceptions.ComponentExtractionException;
import com.e_commerceSystem.repositories.interfaces.ComponentDao;
import com.e_commerceSystem.services.interfaces.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProcessingServiceImp implements ComponentService<Processing> {

    @Autowired
    private ComponentDao componentDao;

    @Override
    public List<Processing> getComponentList() {
        return componentDao.getProcessingAll();
    }

    @Override
    public void addComponent(Processing component) {

        component.setPrice(0.0F);
        component.setPriceUSD(0.0F);
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
    public void deleteComponent(Processing component) {
        componentDao.deleteProcessing(component);
    }

    @Override
    public void updateComponentPrices(Processing component) {
        componentDao.updateProcessingPrices(component);
    }

    @Override
    public boolean canHandle(ComponentTypes componentTypes) {
        return componentTypes == ComponentTypes.PROCESSING;
    }

    @Override
    public Processing getEmptyComponent() {
        return new Processing();
    }

    @Override
    public DefaultComponent extractComponentFromRequest(Map<String, String> params) throws ComponentExtractionException {

        Processing processing = new Processing();
        try {
            if(!params.get("id").isEmpty()) {
                processing.setId(Long.parseLong(params.get("id")));
            }
        } catch (NumberFormatException exception){
            throw new ComponentExtractionException();
        }
        processing.setType(ProcessingType.valueOf(params.get("type")).getNameRus());
        processing.setProcessingType(ProcessingType.valueOf(params.get("type")));
        processing.setName(params.get("name"));
        processing.setSymbol(params.get("symbol"));

        return processing;
    }
}
