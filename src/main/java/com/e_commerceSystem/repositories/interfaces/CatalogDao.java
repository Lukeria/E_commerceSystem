package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Image;

import java.util.List;

public interface CatalogDao {

    Catalog addItem(Catalog catalog);
    void updateItem(Catalog catalog);
    void deleteItem(Catalog catalog);
    List<Catalog> getItemsByProductType(String productType);
    Catalog getItemById(Long id);
    Image storeImage(Image image);
}
