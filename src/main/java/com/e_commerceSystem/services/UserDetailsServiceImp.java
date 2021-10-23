package com.e_commerceSystem.services;

import com.e_commerceSystem.entities.CustomUserDetails;
import com.e_commerceSystem.repositories.interfaces.UserDao;
import com.e_commerceSystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserDao userDetailsDao;

    @Autowired
    public UserDetailsServiceImp(UserDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDetailsDao.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        } else {
            return new CustomUserDetails(user);
        }
    }
}
