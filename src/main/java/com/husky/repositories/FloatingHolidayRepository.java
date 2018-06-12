package com.husky.repositories;

import com.husky.entities.FloatingHoliday;
import com.husky.entity.FloatingHoliday;
import com.husky.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FloatingHolidayRepository extends JpaRepository<FloatingHoliday, Long> {
    List<FloatingHoliday> findByUserGenderAndUserParent(@Param("user_gender") Gender userGender,
                                                        @Param("user_parent") boolean userParent);
}
