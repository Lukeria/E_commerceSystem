package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.additional.enums.ComponentTypes;
import com.e_commerceSystem.entities.components.DefaultComponent;
import com.e_commerceSystem.exceptions.ComponentExtractionException;

import java.util.List;
import java.util.Map;

public interface ComponentService<Type> {

    List<Type> getComponentList();
    void addComponent(Type component);
    Type getComponentById(Long id);
    void updateComponent(Type component);
    void deleteComponent(Type component);
    void updateComponentPrices(Type component);

    boolean canHandle(ComponentTypes componentTypes);
    Type getEmptyComponent();
    DefaultComponent extractComponentFromRequest(Map<String, String> params) throws ComponentExtractionException;
}
