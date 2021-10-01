package com.e_commerceSystem.repositories;

import com.e_commerceSystem.additional.enums.OrderStatus;
import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.Component;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.repositories.interfaces.OrderDao;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImp implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getOrdersByStatus(OrderStatus status) {

        List<Order> orderList = sessionFactory.getCurrentSession()
                .createNamedQuery("get_order_by_status", Order.class)
                .setParameter("order_status", status.toString())
                .getResultList();
        return orderList;
    }

    @Override
    public List<Order> getOrdersByStatusAndCustomer(OrderStatus status, Customer customer) {

        List<Order> orderList = sessionFactory.getCurrentSession()
                .createNamedQuery("get_order_by_status_and_customer_id", Order.class)
                .setParameter("order_status", status.toString())
                .setParameter("customer_id", customer.getId())
                .getResultList();
        return orderList;
    }

    @Override
    public void addOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void updateOrder(Order order) {
        Order orderToUpdate = getOrderById(order.getId());
        orderToUpdate.setDeadline(order.getDeadline());
        orderToUpdate.setProductType(order.getProductType());
        orderToUpdate.setCost(order.getCost());
        for (Glass glass: orderToUpdate.getGlassList()) {
            sessionFactory.getCurrentSession().delete(glass);
        }
        orderToUpdate.setGlassList(order.getGlassList());
        for(Glass glass: orderToUpdate.getGlassList()){
            glass.setOrder(orderToUpdate);
        }
        sessionFactory.getCurrentSession().update(orderToUpdate);
    }

    @Override
    public void updateOrderCustomer(Order order) {
        Order orderToUpdate = getOrderById(order.getId());
        orderToUpdate.setCustomer(order.getCustomer());
        sessionFactory.getCurrentSession().saveOrUpdate(orderToUpdate);
    }

    @Override
    public void updateOrderStatus(Order order) {
        Order orderToUpdate = getOrderById(order.getId());
        orderToUpdate.setStatus(order.getStatus());
        sessionFactory.getCurrentSession().saveOrUpdate(orderToUpdate);
    }

    @Override
    public void deleteOrder(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return sessionFactory.getCurrentSession().get(Order.class, id);
    }
}
