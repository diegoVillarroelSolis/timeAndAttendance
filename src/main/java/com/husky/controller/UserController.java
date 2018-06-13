package com.husky.controller;

import com.husky.entity.Gender;
import com.husky.entity.Request;
import com.husky.entity.User;
import com.husky.repository.RequestRepository;
import com.husky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Inject
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody User newUser){
        userRepository.save(newUser);
    }


}