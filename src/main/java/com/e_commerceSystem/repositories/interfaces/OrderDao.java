package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;

import java.util.List;

public interface OrderDao {

    List<Order> getOrdersByStatus(String status);
    List<Order> getOrdersByStatusAndCustomer(String status, Customer customer);
    void addOrder(Order order);
    void updateOrder();
    void updateOrderCustomer(Order order);
    void deleteOrder();
    Order getOrderById(Long id);
}
