package com.e_commerceSystem.repositories;

import com.e_commerceSystem.entities.Glass;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.entities.components.Processing;
import com.e_commerceSystem.repositories.interfaces.ComponentDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComponentDaoImp implements ComponentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GlassType> getGlassTypeAll() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<GlassType> glassTypeList = session.createNamedQuery("get_glass_type_all", GlassType.class).getResultList();

        session.getTransaction().commit();

        return glassTypeList;
    }

    @Override
    public List<Accessory> getAccessoryAll() {
        return null;
    }

    @Override
    public List<Processing> getProcessingAll() {
        return null;
    }


}
