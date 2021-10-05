package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;

import java.util.List;

public interface CartService {

    List<Order> getOrders(Customer customer);
    Order getOrderById(Long id);
    void addOrder(Order order);
    void deleteOrder(Long id);
    void submitCartOrder(Long id);
}
