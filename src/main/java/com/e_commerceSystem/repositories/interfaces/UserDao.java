package com.e_commerceSystem.repositories.interfaces;

import com.e_commerceSystem.entities.Role;
import com.e_commerceSystem.entities.User;

import java.util.Optional;

public interface UserDao {

    User findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    void saveUser(User user);
    Role getUserRole();

}
