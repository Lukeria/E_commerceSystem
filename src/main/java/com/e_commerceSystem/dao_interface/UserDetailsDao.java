package com.e_commerceSystem.dao_interface;

import com.e_commerceSystem.entities.User;

public interface UserDetailsDao {

    User findUserByUsername(String username);
}
