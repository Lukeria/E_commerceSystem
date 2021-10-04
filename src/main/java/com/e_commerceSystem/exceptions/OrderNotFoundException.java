package com.e_commerceSystem.exceptions;

public class OrderNotFoundException extends NotFoundException {

    public OrderNotFoundException(Long id) {
        super("No such order with id "+id);
    }
}
