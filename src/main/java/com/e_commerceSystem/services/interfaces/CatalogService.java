package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.repositories.interfaces.CatalogDao;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CatalogService {

    Catalog createItem(MultipartFile multipartFile) throws Exception;
    void updateItem(Catalog catalog);
    void deleteItem(Catalog catalog);
    List<Catalog> getItemsByProductType(String productType);
    Catalog getItemById(Long id);
}
