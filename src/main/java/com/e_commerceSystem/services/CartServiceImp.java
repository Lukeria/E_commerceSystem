package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.exceptions.notFoundExceptions.OrderNotFoundException;
import com.e_commerceSystem.repositories.interfaces.OrderDao;
import com.e_commerceSystem.services.interfaces.CalculatorService;
import com.e_commerceSystem.services.interfaces.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private LocalDateTimeHandler dateTimeHandler;
    @Autowired
    private CalculatorService calculatorService;

    @Override
    @Transactional
    public List<Order> getOrders(Customer customer) {
        return orderDao.getCartOrders(OrderStatus.CART, customer);
    }

    @Override
    @Transactional
    public Order getOrderById(Long id) {
        return orderDao.getCartOrderById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @Override
    @Transactional
    public void addOrder(Order order, Customer customer) {

        order.setCustomer(customer);
        order.setCost(calculatorService.calculatePrice(new ArrayList<>(order.getGlassList())));
        order.setStatus(OrderStatus.CART);

        orderDao.saveOrUpdateOrder(order);
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {

        Order order = getOrderById(id);
        orderDao.deleteOrder(order);
    }

    @Override
    @Transactional
    public void submitCartOrder(Long id) {

        Order order = getOrderById(id);

        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime deadLine = dateTimeHandler.addWorkDays(creationDate, 7);

        order.setCreationDate(creationDate);
        order.setDeadline(deadLine);
        order.setStatus(OrderStatus.ACTIVE);

        orderDao.saveOrUpdateOrder(order);

    }
}
