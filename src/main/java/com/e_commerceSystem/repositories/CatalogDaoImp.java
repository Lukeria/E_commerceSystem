package com.e_commerceSystem.repositories;

import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Image;
import com.e_commerceSystem.entities.glass.GlassType;
import com.e_commerceSystem.repositories.interfaces.CatalogDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CatalogDaoImp implements CatalogDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Catalog addItem(Catalog catalog) {
        sessionFactory.getCurrentSession().save(catalog);
        return catalog;
    }

    @Override
    public void updateItem(Catalog catalog) {

    }

    @Override
    public void deleteItem(Catalog catalog) {

    }

    @Override
    public List<Catalog> getItemsByProductType(String productType) {

        Session session = sessionFactory.getCurrentSession();
        List<Catalog> catalogList = session.createQuery("from Catalog", Catalog.class).getResultList();
        return catalogList;
    }

    @Override
    public Catalog getItemById(Long id) {
        return sessionFactory.getCurrentSession().get(Catalog.class, id);
    }

    @Override
    public Image storeImage(Image image) {
        sessionFactory.getCurrentSession().save(image);
        return image;
    }
}
