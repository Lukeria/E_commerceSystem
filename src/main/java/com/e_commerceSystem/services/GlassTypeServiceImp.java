package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.ComponentTypes;
import com.e_commerceSystem.entities.components.DefaultComponent;
import com.e_commerceSystem.entities.glass.GlassType;
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
public class GlassTypeServiceImp implements ComponentService<GlassType> {

    @Autowired
    private ComponentDao componentDao;

    @Override
    public List<GlassType> getComponentList() {
        return componentDao.getGlassTypeAll();
    }

    @Override
    public void addComponent(GlassType component) {

        component.setPrice(0.0F);
        component.setPriceUSD(0.0F);
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
    public void deleteComponent(GlassType component) {
        componentDao.deleteGlassType(component);
    }

    @Override
    public void updateComponentPrices(GlassType component) {
        componentDao.updateGlassTypePrices(component);
    }

    @Override
    public boolean canHandle(ComponentTypes componentTypes) {
        return componentTypes == ComponentTypes.GLASS_TYPE;
    }

    @Override
    public GlassType getEmptyComponent() {
        return new GlassType();
    }

    @Override
    public DefaultComponent extractComponentFromRequest(Map<String, String> params) throws ComponentExtractionException {

        GlassType glassType = new GlassType();
        glassType.setName(params.get("name"));
        try {
            if (!params.get("id").isEmpty()) {
                glassType.setId(Long.parseLong(params.get("id")));
            }
            if (!params.get("thickness").isEmpty()) {
                glassType.setThickness(Integer.parseInt(params.get("thickness")));
            }
        } catch (NumberFormatException exception) {
            throw new ComponentExtractionException();
        }

        return glassType;
    }

}
