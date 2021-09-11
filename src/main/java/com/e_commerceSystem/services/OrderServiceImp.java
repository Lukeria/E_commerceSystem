package com.e_commerceSystem.services;

import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.repositories.interfaces.OrderDao;
import com.e_commerceSystem.services.interfaces.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Order> getOrdersByStatus(String status) {
        return null;
    }

    @Override
    public List<Order> getOrdersByStatusAndCustomer(String status, Customer customer) {
        return null;
    }

    @Override
    public Order addOrder(String status, String productType, Float cost, String glassListJson) {

        ObjectMapper objectMapper = new ObjectMapper();

        List<Glass> table = null;
        try {
            table = objectMapper.readValue(glassListJson, new TypeReference<List<Glass>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        Order order = new Order();
        order.setCost(cost);
        order.setStatus(status);
        order.setCreationDate(LocalDateTime.now());
        order.setProductType(productType);

        for (Glass glass : table) {
            glass.setOrder(order);
            glass.setAmount(0);
            glass.setProcessingList(new HashSet<>(glass.getProcessingArrayList()));
            order.getGlassList().add(glass);
        }

        orderDao.addOrder(order);
        return order;
    }

    @Override
    public void updateOrder() {

    }

    @Override
    public void updateOrderCustomer(Order order) {
        orderDao.updateOrderCustomer(order);
    }

    @Override
    public void deleteOrder() {

    }
}
