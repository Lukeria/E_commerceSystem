package com.e_commerceSystem.repositories;

import com.e_commerceSystem.entities.Glass;
import com.e_commerceSystem.entities.components.Accessory;
import com.e_commerceSystem.entities.components.Component;
import com.e_commerceSystem.entities.components.GlassType;
import com.e_commerceSystem.entities.components.Processing;
import com.e_commerceSystem.repositories.interfaces.ComponentDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ComponentDaoImp implements ComponentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<GlassType> getGlassTypeAll() {

        Session session = sessionFactory.getCurrentSession();
        List<GlassType> glassTypeList = session.createQuery(
                "from Component where component_type=:component_type", Component.class)
                .setParameter("component_type", "glass_type")
                .getResultList()
                .stream()
                .map(value->(GlassType)value)
                .collect(Collectors.toList());
        return glassTypeList;
    }

    @Override
    public GlassType getGlassTypeById(Long id) {
        return sessionFactory.getCurrentSession().get(GlassType.class, id);
    }

    @Override
    public void addGlassType(GlassType glassType) {
        sessionFactory.getCurrentSession().save(glassType);
    }

    @Override
    public void updateGlassType(GlassType glassType) {
        GlassType glassTypeToUpdate = getGlassTypeById(glassType.getId());
        glassTypeToUpdate.setName(glassType.getName());
        glassTypeToUpdate.setThickness(glassType.getThickness());
        sessionFactory.getCurrentSession().update(glassTypeToUpdate);
    }

    @Override
    public void deleteGlassType(GlassType glassType) {

    }

    @Override
    public List<Accessory> getAccessoryAll() {

        Session session = sessionFactory.openSession();
        List<Accessory> accessoryList = session.createQuery("from Accessory", Accessory.class).getResultList();
        return accessoryList;
    }

    @Override
    public Accessory getAccessoryById(Long id) {
        return null;
    }

    @Override
    public void addAccessory(Accessory accessory) {

    }

    @Override
    public void updateAccessory(Accessory accessory) {

    }

    @Override
    public void deleteAccessory(Accessory accessory) {

    }

    @Override
    public List<Processing> getProcessingAll() {

        Session session = sessionFactory.openSession();
        List<Processing> processingList = session.createQuery("from Processing", Processing.class).getResultList();
        return processingList;
    }

    @Override
    public Processing getProcessingById(Long id) {
        return null;
    }

    @Override
    public void addProcessing(Processing processing) {

    }

    @Override
    public void updateProcessing(Processing processing) {

    }

    @Override
    public void deleteProcessing(Processing processing) {

    }


}
