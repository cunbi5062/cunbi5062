package com.example.test.service;

import com.example.test.model.CourseDTO;
import com.example.test.model.UserDTO;

import java.util.List;

public interface CourseService {
    public List<CourseDTO> getCourse(Integer pageNo, Integer pageSize, String sortBy);
}
