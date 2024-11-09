package com.codingAge.Course.Registration.System.Controller;


import com.codingAge.Course.Registration.System.Model.ModelRequest.UserLoginRequest;
import com.codingAge.Course.Registration.System.Model.ModelRequest.UserRequest;
import com.codingAge.Course.Registration.System.Model.User;
import com.codingAge.Course.Registration.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }
    @PostMapping("/loginUser")
    public User login(@RequestBody UserLoginRequest userLoginRequest) {
        return userService.login(userLoginRequest);
    }

    @GetMapping("/seeExistingUser")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/findBYUserID")
    public Optional<User> findByiD(@RequestParam String id){
        return userService.findById(id);
    }

}
