package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Image;
import com.e_commerceSystem.entities.glass.Glass;
import com.e_commerceSystem.exceptions.notFoundExceptions.CatalogNotFoundException;
import com.e_commerceSystem.repositories.interfaces.CatalogDao;
import com.e_commerceSystem.services.interfaces.CatalogService;
import com.sun.javafx.iio.ImageStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class CatalogServiceImp implements CatalogService {

    @Autowired
    private ImageStorageService imageStorageService;
    @Autowired
    private CatalogDao catalogDao;

    @Override
    @Transactional
    public Catalog createItem(MultipartFile file, ProductType productType) throws ImageStorageException {

        try {
            Image image = imageStorageService.getImageFile(file);
            Catalog catalog = new Catalog();
            catalog.setImage(image);
            catalog.setProductType(productType);

            catalogDao.saveOrUpdateItem(catalog);
            return catalog;
        } catch (IOException exception) {
            throw new ImageStorageException("Cannot store the image!");
        }
    }

    @Override
    @Transactional
    public void updateItem(Catalog catalog) {

        Catalog catalogToUpdate = getItemById(catalog.getId());
        catalogToUpdate.setGlassList(catalog.getGlassList());
        catalogToUpdate.setProductType(catalog.getProductType());
//        for(Glass glass: catalogToUpdate.getGlassList()){
//            glass.setCatalog(catalogToUpdate);
//        }
        catalogToUpdate.setAccessories(catalog.getAccessories());

        catalogDao.saveOrUpdateItem(catalogToUpdate);
    }

    @Override
    @Transactional
    public void deleteItem(Long id) {

        Catalog catalog = getItemById(id);
        catalogDao.deleteItem(catalog);
    }

    @Override
    @Transactional
    public List<Catalog> getItemsByProductType(ProductType productType) {

        return catalogDao.getItemsByProductType(productType);
    }

    @Override
    @Transactional
    public Catalog getItemById(Long id) {

        return catalogDao.getItemById(id)
                .orElseThrow(() -> new CatalogNotFoundException(id));
    }

    @Override
    public void prepareForView(Catalog catalog, ProductType productType) {

        if (catalog.isEmpty()) {
            List<Glass> glassList = new ArrayList<Glass>();
            glassList.add(new Glass());

            catalog.setGlassList(new HashSet<>(glassList));

            if (productType != null) {
                catalog.setProductType(productType);
            }
        }
    }
}
