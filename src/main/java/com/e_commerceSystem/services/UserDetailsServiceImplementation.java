package com.e_commerceSystem.services;

import com.e_commerceSystem.dao_interface.UserDetailsDao;
import com.e_commerceSystem.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;


    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDetailsDao.findUserByUsername(username);
        UserBuilder builder;
        if (user != null) {

            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(user.getPassword());
            String[] roles = {user.getRole().getRole()};

            builder.authorities(roles);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }
}
