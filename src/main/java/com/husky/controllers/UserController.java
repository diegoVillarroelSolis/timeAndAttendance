package com.husky.controllers;

import com.husky.entities.User;
import com.husky.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Inject
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUserById (@PathVariable long userId){
        return userRepository.findById(userId).get();
    }
}