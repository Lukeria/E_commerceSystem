package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.ComponentTypes;
import com.e_commerceSystem.services.interfaces.ComponentService_2_0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentServiceFactory {

    @Autowired
    private List<ComponentService_2_0> componentServiceList;

    public ComponentService_2_0 getComponentService(ComponentTypes componentType) {

        return componentServiceList.stream()
                .filter(service -> service.canHandle(componentType))
                .findFirst()
                .get();

    }
}
