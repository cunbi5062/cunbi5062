package com.example.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/course")
public interface CourseController {
    @GetMapping("/searchBy")
    public ResponseEntity<?> getCourse(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                      @RequestParam(name = "pageSize", required = false,  defaultValue = "100") Integer pageSize,
                                      @RequestParam(name = "sortBy", required = false,  defaultValue = "id") String sortBy);
}
