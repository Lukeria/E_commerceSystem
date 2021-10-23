package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> getOrdersByStatus(OrderStatus status);
    List<Order> getOrdersByCustomer(Customer customer);
    List<Order> getOrders(String filter);
    List<Order> getExpiredOrders();
    void addOrder(Order order);
    Order createOrder(Catalog catalog);
    void updateOrder(Order order);
    void updateOrderCustomer(Long id,Customer customer);
    void updateOrderStatus(Long id, OrderStatus status);
    void deleteOrder(Long id);
    Order getOrderById(Long id);
    Map<String, Long> getOrderStatusCount();
    Long getExpiredOrderCount();

    void prepareForView(Order order, ProductType productType);

}
