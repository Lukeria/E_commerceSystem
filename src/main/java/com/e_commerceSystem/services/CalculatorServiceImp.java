package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.enums.ComponentType;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.OrderItem;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.entities.components.Processing;
import com.e_commerceSystem.entities.components.Glass;
import com.e_commerceSystem.services.interfaces.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CalculatorServiceImp implements CalculatorService {

    private final ComponentServiceFactory componentServiceFactory;

    @Autowired
    public CalculatorServiceImp(ComponentServiceFactory componentServiceFactory) {
        this.componentServiceFactory = componentServiceFactory;
    }

    @Override
    public float calculatePrice(Order order) {

        Set<Glass> glassList = order.getGlassList();
        Set<OrderItem> orderItems = order.getAccessories();
        float price = 0;

        for (Glass glass : glassList) {

            float currentGlassPrice = 0;

            float square = glass.getShape().getSquare(glass.getWidth(), glass.getHeight());
            float perimeter = glass.getShape().getPerimeter(glass.getWidth(), glass.getHeight());

            GlassType glassType = (GlassType) componentServiceFactory.getComponentService(ComponentType.GLASS_TYPE).getComponentById(glass.getGlassType().getId());
            currentGlassPrice = square * glassType.getPrice();
            for (Processing currentProcessing : glass.getProcessingList()) {

                Processing processing = (Processing) componentServiceFactory.getComponentService(ComponentType.PROCESSING).getComponentById(currentProcessing.getId());
                currentGlassPrice += processing.getPrice() * perimeter * (currentProcessing.getQuantity() != 0 ? currentProcessing.getQuantity() : 1);
            }

            price += currentGlassPrice * glass.getAmount();
        }

        if (order.getInstallation()) {

            price *= order.getProductType().getRatio();
        }

        for (OrderItem orderItem : orderItems) {

            Accessory accessory = (Accessory) componentServiceFactory.getComponentService(ComponentType.ACCESSORY).getComponentById(orderItem.getComponent().getId());
            price += accessory.getPrice() * orderItem.getAmount();

        }

        return Math.round(price);
    }
}
