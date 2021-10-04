package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;

import java.util.List;

public interface OrderService {

    List<Order> getOrdersByStatus(OrderStatus status);
    List<Order> getOrdersByStatusAndCustomer(OrderStatus status, Customer customer);
    List<Order> getOrders();
    Order addOrder(OrderStatus status, String productType, Float cost, String glassListJson);
    void addOrder(Order order);
    void updateOrder(Order order);
    void updateOrderCustomer(Order order);
    void updateOrderStatus(Order order);
    void deleteOrder(Order order);
    Order getOrderById(Long id);
    Order createOrderByCatalog(Catalog catalog);
    void prepareForView(Order order, ProductType productType);

}
