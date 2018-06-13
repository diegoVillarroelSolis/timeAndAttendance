package com.husky.controller;

import com.husky.entity.FloatingHoliday;
import com.husky.entity.Gender;
import com.husky.entity.User;
import com.husky.repository.FloatingHolidayRepository;
import com.husky.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Luis on 04/06/2018.
 */
@RestController
public class FloatingHolidayController {
    @Inject
    private FloatingHolidayRepository floatingHolidayRepository;
    @Inject
    private UserRepository userRepository;
    @RequestMapping(value = "/floatings", method = RequestMethod.GET)
    public List<FloatingHoliday> getAllFloating(){
        return floatingHolidayRepository.findAll();
    }

    @RequestMapping(value = "/floatings", method = RequestMethod.POST)
    public FloatingHoliday addFloating(@RequestBody FloatingHoliday newFloating){
        return floatingHolidayRepository.save(newFloating);
    }

    @RequestMapping(value = "/users/{userId}/floatings", method = RequestMethod.GET)
    public List<FloatingHoliday> getAllFloatingByUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).get();
        return floatingHolidayRepository.findByUserGenderAndUserParent(user.getGender(), user.isIsParent());
      //return null;
    }
}
