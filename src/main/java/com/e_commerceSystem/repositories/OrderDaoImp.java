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
import java.util.Optional;

@Repository
public class OrderDaoImp implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getOrdersByStatus(OrderStatus status) {

        List<Order> orderList = sessionFactory.getCurrentSession()
                .createNamedQuery("get_orders_by_status", Order.class)
                .setParameter("order_status", status.toString())
                .getResultList();
        return orderList;
    }

    @Override
    public List<Order> getOrders() {

        List<Order> orderList = sessionFactory.getCurrentSession()
                .createNamedQuery("get_orders", Order.class)
                .setParameter("order_status", OrderStatus.CART.toString())
                .getResultList();
        return orderList;
    }

    @Override
    public Optional<Order> getOrderById(Long id) {

        List<Order> orderList = sessionFactory.getCurrentSession()
                .createNamedQuery("get_order_by_id", Order.class)
                .setParameter("order_status", OrderStatus.CART.toString())
                .setParameter("id", id)
                .getResultList();
        return orderList.stream().findFirst();

    }

    @Override
    public List<Order> getCartOrders(OrderStatus status, Customer customer) {

        List<Order> orderList = sessionFactory.getCurrentSession()
                .createNamedQuery("get_cart_orders", Order.class)
                .setParameter("order_status", status.toString())
                .setParameter("customer_id", customer.getId())
                .getResultList();
        return orderList;
    }

    @Override
    public Optional<Order> getCartOrderById(Long id) {

        List<Order> orderList = sessionFactory.getCurrentSession()
                .createNamedQuery("get_cart_order_by_id", Order.class)
                .setParameter("order_status", OrderStatus.CART.toString())
                .setParameter("id", id)
                .getResultList();
        return orderList.stream().findFirst();
    }

    @Override
    public void saveOrUpdateOrder(Order order) {
        sessionFactory.getCurrentSession().saveOrUpdate(order);
    }

    @Override
    public void deleteOrder(Order order) {
        sessionFactory.getCurrentSession().delete(order);
    }

}
