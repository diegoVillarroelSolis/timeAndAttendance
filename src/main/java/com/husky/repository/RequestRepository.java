package com.husky.repository;

import com.husky.entity.FloatingHoliday;
import com.husky.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Luis on 04/06/2018.
 */
public interface RequestRepository extends JpaRepository<Request, Long>{
    List<Request> findByUserId(Long id);
}
