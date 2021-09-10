package com.e_commerceSystem.repositories;

import com.e_commerceSystem.entities.Customer;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.repositories.interfaces.OrderDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImp implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

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
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public void addGlass(Glass glass){
        sessionFactory.getCurrentSession().persist(glass);
    }
    @Override
    public void updateOrder() {

    }

    @Override
    public void deleteOrder() {

    }
}
