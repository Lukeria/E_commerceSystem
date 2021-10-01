package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Image;
import com.e_commerceSystem.repositories.interfaces.CatalogDao;
import com.e_commerceSystem.services.interfaces.CatalogService;
import com.sun.javafx.iio.ImageStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class CatalogServiceImp implements CatalogService {

    @Autowired
    private ImageStorageService imageStorageService;
    @Autowired
    private CatalogDao catalogDao;

    @Override
    public Catalog createItem(MultipartFile file, ProductType productType) throws ImageStorageException {

        try {
            Image image = imageStorageService.getImageFile(file);
            Catalog catalog = new Catalog();
            catalog.setImage(image);
            catalog.setProductType(productType);

            return catalogDao.addItem(catalog);
        } catch (IOException exception) {
            throw new ImageStorageException("Cannot store the image!");
        }
    }

    @Override
    public Catalog updateItem(Catalog catalog) {

        catalogDao.updateItem(catalog);
        return catalog;
    }

    @Override
    public void deleteItem(Long id) {

        Catalog catalog = getItemById(id);
        catalogDao.deleteItem(catalog);
    }

    @Override
    public List<Catalog> getItemsByProductType(ProductType productType) {
        return catalogDao.getItemsByProductType(productType);
    }

    @Override
    public Catalog getItemById(Long id) {
        return catalogDao.getItemById(id);
    }
}
