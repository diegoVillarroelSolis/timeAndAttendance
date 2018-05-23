package com.husky.Controllers;

import com.husky.Entities.User;
import com.husky.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users") // URL start with users
public class UserController {

    private UserRepository userRepository;

    @Autowired //repository (bean)
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<User> create(@RequestBody User user) {
        userRepository.save(user);
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById (@PathVariable long id){
        return userRepository.findById(id).get();
    }
}