package com.husky.controllers;

import com.husky.entities.User;
import com.husky.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
public class UserController {

    @Inject
    private UserRepository userRepository;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public List<User> create(@RequestBody User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById (@PathVariable long id){
        return userRepository.findById(id).get();
    }
}