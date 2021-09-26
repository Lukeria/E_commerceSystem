package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;

import java.util.List;

public interface OrderService {

    List<Order> getOrdersByStatus(String status);
    List<Order> getOrdersByStatusAndCustomer(String status, Customer customer);
    Order addOrder(String status, String productType, Float cost, String glassListJson);
    void addOrder(Order order);
    void updateOrder(Order order);
    void updateOrderCustomer(Order order);
    void updateOrderStatus(Order order);
    void deleteOrder(Order order);
    Order getOrderById(Long id);

}
