package com.e_commerceSystem.exceptions.notFoundExceptions;

public class CatalogNotFoundException extends NotFoundException {

    public CatalogNotFoundException(Long id) {
        super("No such catalog item with id " + id);
    }
}
