package com.codingAge.Course.Registration.System.Service;

import com.codingAge.Course.Registration.System.Exception.UserException;
import com.codingAge.Course.Registration.System.Model.ModelRequest.UserLoginRequest;
import com.codingAge.Course.Registration.System.Model.ModelRequest.UserRequest;
import com.codingAge.Course.Registration.System.Model.Register;
import com.codingAge.Course.Registration.System.Model.User;
import com.codingAge.Course.Registration.System.Repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequest userRequest){

        // Check if user already exists by userName
        User existingUser = userRepository.findByUsername(userRequest.getUsername());
        if (existingUser!=null) {
            // Throw custom exception if user already exists
            throw new UserException("User with username '" + userRequest.getUsername() + "' already exists.");
        }

        User user1 = new User();
        user1.setUsername(userRequest.getUsername());
        user1.setPassword(userRequest.getPassword());
        user1.setRole(userRequest.getRole());
        System.out.println(userRequest.getPassword());// No password hashing

        return userRepository.save(user1);
    }

   public User login(@RequestBody UserLoginRequest userLoginRequest) {
       // Find user by userName
       User user = userRepository.findByUsername(userLoginRequest.getUsername());
       if (user!=null) {
           // Check if password matches
           if (user.getPassword().equals(userLoginRequest.getPassword())) {
               return user;
           } else {
               throw new UserException("Invalid password.");
           }
       }
       // Throw exception if user not found
       throw new UserException("User with username '" + userLoginRequest.getUsername() + "' not found.");
   }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Optional<User> findById(String id) {
       return userRepository.findById(id);
    }

}
