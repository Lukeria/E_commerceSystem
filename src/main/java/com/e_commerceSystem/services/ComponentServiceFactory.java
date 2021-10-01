package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.enums.ComponentTypes;
import com.e_commerceSystem.services.interfaces.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentServiceFactory {

    @Autowired
    private List<ComponentService> componentServiceList;

    public ComponentService getComponentService(ComponentTypes componentType) {

        return componentServiceList.stream()
                .filter(service -> service.canHandle(componentType))
                .findFirst()
                .get();

    }
}
