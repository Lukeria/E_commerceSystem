package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.exceptions.notFoundExceptions.OrderNotFoundException;
import com.e_commerceSystem.repositories.interfaces.OrderDao;
import com.e_commerceSystem.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private LocalDateTimeHandler dateTimeHandler;

    @Override
    @Transactional
    public List<Order> getOrdersByStatus(OrderStatus status) {

        return orderDao.getOrdersByStatus(status);
    }

    @Override
    @Transactional
    public List<Order> getOrders() {

        return orderDao.getOrders();
    }

    @Override
    @Transactional
    public void addOrder(Order order) {

        LocalDateTime creationDate = LocalDateTime.now();
        LocalDateTime deadLine = dateTimeHandler.addWorkDays(creationDate, 7);

        order.setCreationDate(creationDate);
        order.setDeadline(deadLine);

//        for (Glass glass : order.getGlassList()) {
//            glass.setOrder(order);
//        }

        orderDao.saveOrUpdateOrder(order);
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {

        Order orderToUpdate = getOrderById(order.getId());
        orderToUpdate.setProductType(order.getProductType());
        orderToUpdate.setCost(order.getCost());
        orderToUpdate.setGlassList(order.getGlassList());
//        for (Glass glass : orderToUpdate.getGlassList()) {
//            glass.setOrder(orderToUpdate);
//        }

        orderDao.saveOrUpdateOrder(order);
    }

    @Override
    @Transactional
    public void updateOrderCustomer(Order order) {

        Order orderToUpdate = getOrderById(order.getId());
        orderToUpdate.setCustomer(order.getCustomer());

        orderDao.saveOrUpdateOrder(orderToUpdate);
    }

    @Override
    @Transactional
    public void updateOrderStatus(Long id, OrderStatus status) {

        Order order = getOrderById(id);
        order.setStatus(status);
        orderDao.saveOrUpdateOrder(order);

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
    public Order createOrder(Catalog catalog) {

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
            order.setProductType(productType.getName());
        }
    }
}
