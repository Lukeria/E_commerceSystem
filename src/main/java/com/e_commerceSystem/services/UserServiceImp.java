package com.e_commerceSystem.services;

import com.e_commerceSystem.entities.User;
import com.e_commerceSystem.exceptions.UserAlreadyExistsException;
import com.e_commerceSystem.repositories.UserDaoImp;
import com.e_commerceSystem.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDaoImp userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findUserByEmail(String email) {

        return userDao.findUserByEmail(email)
                .orElseThrow(UserAlreadyExistsException::new);
    }

    @Override
    public void registerNewUser(User user) {

        if(userDao.findUserByEmail(user.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        } else{
            user.getCustomer().setEmail(user.getEmail());
            user.setRole(userDao.getUserRole());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userDao.saveUser(user);
        }
    }
}
