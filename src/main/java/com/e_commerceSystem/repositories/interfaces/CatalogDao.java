package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.additional.enums.ProductType;
import com.e_commerceSystem.entities.Catalog;
import com.e_commerceSystem.entities.Image;
import com.e_commerceSystem.entities.glass.Glass;

import java.util.List;
import java.util.Optional;

public interface CatalogDao {

    void saveOrUpdateItem(Catalog catalog); //save
    void deleteItem(Catalog catalog);
    List<Catalog> getItemsByProductType(ProductType productType);
    Optional<Catalog> getItemById(Long id);
}
