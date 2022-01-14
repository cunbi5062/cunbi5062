package com.example.test.controller.impl;

import com.example.test.controller.CourseController;
import com.example.test.model.CourseDTO;
import com.example.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CourseControllerImpl implements CourseController {
    @Autowired
    CourseService courseService;

    @Override
    public ResponseEntity<?> getCourse(Integer pageNo, Integer pageSize, String sortBy) {
        List<CourseDTO> courseDTOS = courseService.getCourse(pageNo, pageSize, sortBy);
        return ResponseEntity.ok(courseDTOS);
    }
}
