package com.husky.repositories;

import com.husky.entities.FloatingHoliday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloatingHolidayRepository extends JpaRepository<FloatingHoliday, Long> {
    //@Query("SELECT f.description FROM Request r, FloatingHoliday f WHERE r.floating_holiday.id = f.id AND r.id = :id")
    //FloatingHoliday findByRequestId(@Param("request_id") Long request_id);
}
