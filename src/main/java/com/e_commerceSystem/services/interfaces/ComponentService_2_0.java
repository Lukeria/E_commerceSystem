package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.additional.ComponentTypes;
import com.e_commerceSystem.entities.components.Component;
import com.e_commerceSystem.entities.glass.GlassType;

import java.util.List;

public interface ComponentService_2_0<Type> {

    List<Type> getComponentList();
    void addComponent(Type component);
    Type getComponentById(Long id);
    void updateComponent(Type component);

    boolean canHandle(ComponentTypes componentTypes);
}
