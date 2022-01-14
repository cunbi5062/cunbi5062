package com.example.test.service;

import com.example.test.entity.Deparment;
import com.example.test.entity.User;
import com.example.test.model.CourseDTO;
import com.example.test.model.DeparmentDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface DeparmentService {
    DeparmentDTO insert(DeparmentDTO deparmentDTO) throws ParseException;
    public List<DeparmentDTO> getDeparment(Integer pageNo, Integer pageSize, String sortBy);
    void delete(int id);

}
