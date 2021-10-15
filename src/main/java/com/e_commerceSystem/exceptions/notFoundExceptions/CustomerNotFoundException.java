package com.e_commerceSystem.exceptions.notFoundExceptions;

public class CustomerNotFoundException extends NotFoundException{

    public CustomerNotFoundException(Long id) {

        super("No such customer with id "+id);
    }
}
