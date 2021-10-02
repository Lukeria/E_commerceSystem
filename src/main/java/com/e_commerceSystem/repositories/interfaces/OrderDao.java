package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;

import java.util.List;

public interface OrderDao {

    List<Order> getOrdersByStatus(OrderStatus status);
    List<Order> getOrdersByStatusAndCustomer(OrderStatus status, Customer customer);
    List<Order> getOrders();
    void addOrder(Order order);
    void updateOrder(Order order);
    void updateOrderCustomer(Order order);
    void updateOrderStatus(Order order);
    void deleteOrder(Order order);
    Order getOrderById(Long id);
}
