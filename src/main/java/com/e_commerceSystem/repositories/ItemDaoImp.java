package com.e_commerceSystem.repositories;

import com.e_commerceSystem.dao_interface.ItemDao;
import com.e_commerceSystem.entities.User;
import com.e_commerceSystem.entities.items.Glass;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ItemDaoImp implements ItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Glass getGlassByTypeThickness(String type, int thickness){

        Query<Glass> query;
        try (Session session = sessionFactory.getCurrentSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Glass> criteriaQuery = criteriaBuilder.createQuery(Glass.class);
            Root<Glass> root = criteriaQuery.from(Glass.class);

            Predicate typeParam = criteriaBuilder.equal(root.get("glassType"), type);
            Predicate thicknessParam = criteriaBuilder.equal(root.get("thickness"), thickness);

            criteriaQuery.select(root).where(criteriaBuilder.and(typeParam, thicknessParam));

            query = session.createQuery(criteriaQuery);
        }
        List<Glass> results = query.getResultList();

        Glass glass = null;
        if(! results.isEmpty()){
            glass = results.get(0);
        }
//        List<Glass> glassList = sessionFactory.openSession().createNamedQuery("get_glass_by_fields", Glass.class)
//                .setParameter("type", type)
//                .setParameter("thickness", thickness)
//                .getResultList();
//
//        return glassList.get(0);
        return glass;
    }

    @Override
    public List<Glass> getGlassAll() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Glass> glassList = session.createNamedQuery("get_glass_all", Glass.class).getResultList();

        session.getTransaction().commit();

        return glassList;
    }

}
