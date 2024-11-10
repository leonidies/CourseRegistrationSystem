package com.codingAge.Course.Registration.System.Repository;

import com.codingAge.Course.Registration.System.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(String username);

}
