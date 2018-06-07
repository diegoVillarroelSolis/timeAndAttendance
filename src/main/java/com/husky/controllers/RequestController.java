package com.husky.controllers;

import com.husky.entities.Request;
import com.husky.repositories.RequestRepository;
import com.husky.repositories.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;
import java.util.NoSuchElementException;

public class RequestController {
    @Inject
    private UserRepository userRepository;

    @Inject
    private RequestRepository requestRepository;

    @RequestMapping(value ="/users/{user_id}/requests", method = RequestMethod.GET)
    public List<Request> getRequestsByUserId(@PathVariable(value = "user_id") Long user_id){
        return requestRepository.findByUserId(user_id);
    }

    @RequestMapping(value="/users/{user_id}/requests", method = RequestMethod.POST)
    public Request createRequest(@PathVariable(value = "user_id") Long user_id, @RequestBody Request request){
        return userRepository.findById(user_id).map(user -> {
            request.setUser(user);
            return requestRepository.save(request);
        }).orElseThrow(() -> new RuntimeException("User id" + user_id + "Not Found"));
    }
}
