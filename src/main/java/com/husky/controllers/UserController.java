package com.husky.controllers;

import com.husky.entities.Request;
import com.husky.entities.User;
import com.husky.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById (@PathVariable long id){
        return userRepository.findById(id).get();
    }
}