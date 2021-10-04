package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;

import java.util.List;
import java.util.Optional;

public interface OrderDao {

    List<Order> getOrdersByStatus(OrderStatus status);
    List<Order> getOrdersByStatusAndCustomer(OrderStatus status, Customer customer); //get cart orders
    List<Order> getOrders();

    void addOrder(Order order); //save order
    void deleteOrder(Order order);

    Optional<Order> getOrderById(Long id);
//    Optional<Order> getCartOrderById(Long id);


    void updateOrder(Order order);
    void updateOrderCustomer(Order order);
    void updateOrderStatus(Order order);

}
