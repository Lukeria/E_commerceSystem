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
    List<Order> getOrders();
    void addOrder(Order order);
    Order createOrder(Catalog catalog);
    void updateOrder(Order order);
    void updateOrderCustomer(Order order);
    void updateOrderStatus(Long id, OrderStatus status);
    void deleteOrder(Long id);
    Order getOrderById(Long id);
    void prepareForView(Order order, ProductType productType);

}
