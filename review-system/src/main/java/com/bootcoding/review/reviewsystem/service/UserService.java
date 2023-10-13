package com.bootcoding.review.reviewsystem.service;

import com.bootcoding.review.reviewsystem.model.User;
import com.bootcoding.review.reviewsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String createUser(User user) {

        print(user);
        userRepository.save(user);
        return "SUCCESSFULLY USER CREATED!";
    }

    private void print(User user) {
        System.out.print(user.getUsername());
        System.out.print(user.getEmailId());
        System.out.print(user.getPhone());
    }
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }
    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

}