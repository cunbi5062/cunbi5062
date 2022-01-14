package com.example.test.service.impl;

import com.example.test.entity.Course;
import com.example.test.entity.Deparment;
import com.example.test.entity.User;
import com.example.test.mapper.DeparmentMapper;
import com.example.test.model.CourseDTO;
import com.example.test.model.DeparmentDTO;
import com.example.test.model.UserDTO;
import com.example.test.repository.DeparmentRepository;
import com.example.test.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class DeparmentServiceImpl implements DeparmentService {
    @Autowired
    DeparmentRepository deparmentRepository;
    @Autowired
    DeparmentMapper deparmentMapper;


    @Override
    public DeparmentDTO insert(DeparmentDTO deparmentDTO) throws ParseException {
        Deparment deparment = deparmentMapper.toDeparment(deparmentDTO);
        deparment = deparmentRepository.save(deparment);
        return deparmentMapper.toDeparmentDTO(deparment);
    }


    @Override
    public List<DeparmentDTO> getDeparment(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo - 1, pageSize, Sort.by(sortBy).ascending());
        Page<Deparment> result = deparmentRepository.findAll(paging);
        List<DeparmentDTO> finalResult = new ArrayList<>();
        for (Deparment deparment : result) {
            finalResult.add(deparmentMapper.toDeparmentDTO(deparment));
        }
        return finalResult;
    }

    @Override
    public void delete(int id) {

        Deparment deparment = deparmentRepository.getById(id);
        if (deparment != null) {
            deparmentRepository.delete(deparment);
        }

    }
}
