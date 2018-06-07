package com.husky.controllers;

import com.husky.entities.Request;
import com.husky.repositories.RequestRepository;
import com.husky.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class RequestController {
    @Inject
    private UserRepository userRepository;

    @Inject
    private RequestRepository requestRepository;

    @RequestMapping(value ="/{userId}/requests", method = RequestMethod.GET)
    public List<Request> getRequestsByUserId(@PathVariable(value = "userId") Long user_id){
        return requestRepository.findByUserId(user_id);
    }

    @RequestMapping(value="/{userId}/requests", method = RequestMethod.POST)
    public Request createRequest(@PathVariable(value = "userId") Long user_id, @RequestBody Request request){
        return userRepository.findById(user_id).map(user -> {
            request.setUser(user);
            return requestRepository.save(request);
        }).orElseThrow(() -> new RuntimeException("User id" + user_id + "Not Found"));
    }
}
