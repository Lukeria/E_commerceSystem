package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.entities.User;

public interface UserDetailsDao {

    User findUserByUsername(String username);
}
