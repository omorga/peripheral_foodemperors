package com.isssr.foodemperors.repository;

import com.isssr.foodemperors.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * Created by marco on 19/05/17.
 */
public interface UserRepository extends MongoRepository<User, Long> {

    List<User> findAll();
    User findByUsernameAndPassword(String username,String password);
}

