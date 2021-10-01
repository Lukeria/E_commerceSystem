package com.e_commerceSystem.repositories;

import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Image;
import com.e_commerceSystem.entities.Order;
import com.e_commerceSystem.entities.glass.Glass;
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

        Catalog catalogToUpdate = getItemById(catalog.getId());
        catalogToUpdate.setProductType(catalog.getProductType());
        for (Glass glass: catalogToUpdate.getGlassList()) {
            sessionFactory.getCurrentSession().delete(glass);
        }
        catalogToUpdate.setGlassList(catalog.getGlassList());
        for(Glass glass: catalogToUpdate.getGlassList()){
            glass.setCatalog(catalogToUpdate);
        }
        sessionFactory.getCurrentSession().update(catalogToUpdate);
    }

    @Override
    public void deleteItem(Catalog catalog) {

        sessionFactory.getCurrentSession().delete(catalog);
    }

    @Override
    public List<Catalog> getItemsByProductType(ProductType productType) {

        List<Catalog> catalogList = sessionFactory.getCurrentSession()
                .createNamedQuery("get_catalog_by_productType", Catalog.class)
                .setParameter("product_type", productType.toString())
                .getResultList();

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
