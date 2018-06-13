package com.husky.repository;

import com.husky.entity.FloatingHoliday;
import com.husky.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Luis on 04/06/2018.
 */

public interface FloatingHolidayRepository extends JpaRepository<FloatingHoliday, Long> {

    List<FloatingHoliday> findByUserGenderAndUserParent(@Param("user_gender") Gender userGender,
                                                        @Param("user_parent") boolean userParent);
}
