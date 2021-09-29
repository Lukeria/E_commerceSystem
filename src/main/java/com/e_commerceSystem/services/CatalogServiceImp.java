package com.e_commerceSystem.services;

import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Image;
import com.e_commerceSystem.repositories.interfaces.CatalogDao;
import com.e_commerceSystem.services.interfaces.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@Transactional
public class CatalogServiceImp implements CatalogService {

    @Autowired
    private ImageStorageService imageStorageService;
    @Autowired
    private CatalogDao catalogDao;

    @Override
    public Catalog createItem(MultipartFile file, ProductType productType) throws Exception{

        try {
            Image image = imageStorageService.getImageFile(file);
            Catalog catalog = new Catalog();
            catalog.setImage(image);
            catalog.setProductType(productType.toString());

            return catalogDao.addItem(catalog);
        } catch (IOException exception){
            throw new Exception();
        }
    }

    @Override
    public Catalog updateItem(Catalog catalog) {
        catalogDao.updateItem(catalog);
        return catalog;
    }

    @Override
    public void deleteItem(Catalog catalog) {
        catalogDao.deleteItem(catalog);
    }

    @Override
    public List<Catalog> getItemsByProductType(String productType) {
        return catalogDao.getItemsByProductType(productType);
    }

    @Override
    public Catalog getItemById(Long id) {
        return catalogDao.getItemById(id);
    }
}
