package com.husky.Controllers;

import com.husky.Entities.User;
import com.husky.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // class is a controller
@RequestMapping(path = "/user") // URL start with demo
public class UserController {

    private UserRepository userRepository;

    @Autowired //repository (bean)
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<User> create(@RequestBody User user) {
        userRepository.save(user);

        return userRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<User> delete(@PathVariable long id) {
        userRepository.deleteById(id);

        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById (@PathVariable long id){
        return userRepository.findById(id).get();
    }

    /*@RequestMapping(method = RequestMethod.GET)
    public User getUser(@RequestParam(value="name") String name) {
        return userRepository.findByName(name);
    }*/
}