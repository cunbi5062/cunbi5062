package com.example.test.service.impl;


import com.example.test.entity.Course;
import com.example.test.entity.User;
import com.example.test.mapper.CourseMapper;
import com.example.test.model.CourseDTO;
import com.example.test.model.UserDTO;
import com.example.test.repository.CourseRepository;
import com.example.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<CourseDTO> getCourse(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo - 1, pageSize, Sort.by(sortBy).ascending());
        Page<Course> result = courseRepository.findAll(paging);
        List<CourseDTO> finalResult = new ArrayList<>();
        for (Course course : result) {
            finalResult.add(courseMapper.toCourseDTO(course));
        }
        return finalResult;
    }
}

