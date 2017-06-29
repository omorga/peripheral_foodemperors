package com.isssr.foodemperors.service;

import com.isssr.foodemperors.model.User;
import com.isssr.foodemperors.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Caim03 on 26/06/17.
 */

@Service
public class UserService {
    
    @Inject
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User login(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
