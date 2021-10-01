package com.e_commerceSystem.services.interfaces;

import com.e_commerceSystem.entities.Role;
import com.e_commerceSystem.entities.User;

public interface UserService {

    User findUserByEmail(String email);
    void registerNewUser(User user);

}
