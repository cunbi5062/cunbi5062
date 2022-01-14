package com.example.test.repository;

import com.example.test.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
