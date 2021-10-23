package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.Customer;
import org.springframework.security.core.Authentication;

public interface CustomerService {

    void update(Customer customer, Authentication authentication);
    Customer getById(Long id);
}
