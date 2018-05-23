package com.husky.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.husky.entities.FloatingHoliday;

public interface FloatingHolidayRepository extends JpaRepository<FloatingHoliday, Long> {
}
