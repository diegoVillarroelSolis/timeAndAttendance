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
    public List<Request> getRequestsByUserId(@PathVariable(value = "userId") Long userId){
        return requestRepository.findByUserId(userId);
    }

    @RequestMapping(value="/{userId}/requests", method = RequestMethod.POST)
    public Request createRequest(@PathVariable(value = "userId") Long userId, @RequestBody Request request){
        return userRepository.findById(userId).map(user -> {
            request.setUser(user);
            return requestRepository.save(request);
        }).orElseThrow(() -> new RuntimeException("User id" + userId + "Not Found"));
    }
}
