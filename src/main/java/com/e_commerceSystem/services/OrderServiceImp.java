package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.exceptions.OrderNotFoundException;
import com.e_commerceSystem.repositories.interfaces.OrderDao;
import com.e_commerceSystem.services.interfaces.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderDao.getOrdersByStatus(status);
    }

    @Override
    @Transactional
    public List<Order> getOrdersByStatusAndCustomer(OrderStatus status, Customer customer) {
        return orderDao.getOrdersByStatusAndCustomer(status, customer);
    }

    @Override
    @Transactional
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    @Transactional
    public void addOrder(Order order) {

        order.setCreationDate(LocalDateTime.now());
        for (Glass glass : order.getGlassList()) {
            glass.setOrder(order);
        }

        orderDao.addOrder(order);
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    @Transactional
    public void updateOrderCustomer(Order order) {
        orderDao.updateOrderCustomer(order);
    }

    @Override
    @Transactional
    public void updateOrderStatus(Long id, OrderStatus status) {

        Order order = getOrderById(id);
        order.setStatus(status);
        orderDao.updateOrderStatus(order);

    }

    @Override
    @Transactional
    public void deleteOrder(Long id){

        Order order = getOrderById(id);
        orderDao.deleteOrder(order);

    }

    @Override
    @Transactional
    public Order getOrderById(Long id) throws OrderNotFoundException {

        return orderDao.getOrderById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    public Order createOrderByCatalog(Catalog catalog) {

        Order order = new Order();
        order.setProductType(catalog.getProductType().getName());
        order.setGlassList(catalog.getGlassList());

        return order;
    }

    @Override
    public void prepareForView(Order order, ProductType productType) {

        List<Glass> glassList = new ArrayList<Glass>();
        glassList.add(new Glass());

        order.setGlassList(new HashSet<>(glassList));

        if (productType != null) {
            order.setProductType(productType.getRepresentation());
        }
    }
}
