package com.e_commerceSystem.services;

import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.repositories.interfaces.OrderDao;
import com.e_commerceSystem.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public void addGlass(Glass glass){
        orderDao.addGlass(glass);
    }


    @Override
    public void updateOrder() {

    }

    @Override
    public void deleteOrder() {

    }
}
