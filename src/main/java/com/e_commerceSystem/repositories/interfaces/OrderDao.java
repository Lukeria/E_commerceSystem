package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;

import java.util.List;
import java.util.Optional;

public interface OrderDao {

    List<Order> getOrdersByStatus(OrderStatus status);
    List<Order> getOrders();
    Optional<Order> getOrderById(Long id);

    List<Order> getCartOrders(OrderStatus status, Customer customer);
    Optional<Order> getCartOrderById(Long id);

    void deleteOrder(Order order);
    void saveOrUpdateOrder(Order order);

}
