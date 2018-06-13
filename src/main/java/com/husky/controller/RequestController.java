package com.husky.controller;

import com.husky.entity.FloatingHoliday;
import com.husky.entity.Request;
import com.husky.exception.ResourceNotFoundException;
import com.husky.repository.FloatingHolidayRepository;
import com.husky.repository.RequestRepository;
import com.husky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;
import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by Luis on 04/06/2018.
 */
@RestController
public class RequestController {
    @Inject
    private RequestRepository requestRepository;
    @Inject
    private UserRepository userRepository;

    @RequestMapping(value = "/users/{userId}/requests", method = RequestMethod.GET)
    public List<Request> getRequestById(@PathVariable Long userId){
        return requestRepository.findByUserId(userId);
    }

    @RequestMapping(value="/users/{userId}/requests", method = RequestMethod.POST)
    public Request createRequest(@PathVariable(value = "userId") Long userId, @RequestBody Request request){
        return userRepository.findById(userId).map(user -> {
            request.setUser(user);
            return requestRepository.save(request);
        }).orElseThrow(() -> new ResourceNotFoundException("User id" + userId + "Not Found"));
    }

}
