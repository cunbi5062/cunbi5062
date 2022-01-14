package com.example.test.controller.impl;

import com.example.test.controller.DeparmentController;
import com.example.test.entity.Deparment;
import com.example.test.model.CourseDTO;
import com.example.test.model.DeparmentDTO;
import com.example.test.service.DeparmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController

public class DeparmentControllerImpl implements DeparmentController {

    @Autowired
    private DeparmentService deparmentService;

    @Override
    public ResponseEntity<DeparmentDTO> createDeparment(DeparmentDTO deparmentDTO) throws ParseException {

        DeparmentDTO response = deparmentService.insert(deparmentDTO);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> getDeparments(Integer pageNo, Integer pageSize, String sortBy) {
        List<DeparmentDTO> deparmentDTOS = deparmentService.getDeparment(pageNo, pageSize, sortBy);
        return ResponseEntity.ok(deparmentDTOS);
    }

    @Override
    public ResponseEntity<?> deleteDeparment(int id) {
        deparmentService.delete(id);
        return ResponseEntity.ok().build();
    }

}
