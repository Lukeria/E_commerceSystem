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

    @Autowired
    private UserDao userDetailsDao;


    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDetailsDao.findUserByUsername(username);
//        UserBuilder builder;
        if (user == null) {
//
//            builder = org.springframework.security.core.userdetails.User.withUsername(username);
//            builder.password(user.getPassword());
//            String[] roles = {user.getRole().getRole()};
//
//            builder.authorities(roles);
            throw new UsernameNotFoundException("User not found.");
        } else {
            return new CustomUserDetails(user);
        }
//        return builder.build();
    }
}
