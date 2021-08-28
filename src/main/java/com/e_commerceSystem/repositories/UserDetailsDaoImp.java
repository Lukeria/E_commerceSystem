package com.e_commerceSystem.repositories;

import com.e_commerceSystem.repositories.interfaces.UserDetailsDao;
import com.e_commerceSystem.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDetailsDaoImp implements UserDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUserByUsername(String username) {

        List<User> results;
            Session session = sessionFactory.getCurrentSession();
            Query<User> query;
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"), username));

            query = session.createQuery(criteriaQuery);
            results = query.getResultList();

        User user = null;
        if(! results.isEmpty()){
            user = results.get(0);
        }

        return user;
    }
}
