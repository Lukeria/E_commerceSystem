package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.entities.Customer;

import java.util.Optional;

public interface CustomerDao {

    void saveOrUpdate(Customer customer);
    Optional<Customer> getById(Long id);
}
