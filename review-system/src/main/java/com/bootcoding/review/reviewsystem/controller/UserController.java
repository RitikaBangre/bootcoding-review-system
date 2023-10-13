package com.bootcoding.review.reviewsystem.controller;

import com.bootcoding.review.reviewsystem.model.User;
import com.bootcoding.review.reviewsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;
@GetMapping("/health/check")
    public String heathcheckup(){
    return "I am alive!";
    }
    @PostMapping("/user")
    public String createUser(@RequestBody User user){

        return userService.createUser(user);
    
    }
@GetMapping("/user")
    public List<User> getallUsers(){
    return userService.getAllUsers();
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
    return userService.getUserById(id);
    }
}
