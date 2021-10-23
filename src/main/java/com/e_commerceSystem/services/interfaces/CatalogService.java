package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.sun.javafx.iio.ImageStorageException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CatalogService {

    Catalog createItem(MultipartFile multipartFile, ProductType productType) throws ImageStorageException;
    void updateItem(Catalog catalog);
    void deleteItem(Long id);
    List<Catalog> getItemsByProductType(ProductType productType);
    Catalog getItemById(Long id);
    void prepareForView(Catalog catalog, ProductType productType);
}
