package com.example.test.controller;

import com.example.test.entity.Deparment;
import com.example.test.entity.User;
import com.example.test.model.DeparmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RequestMapping("/deparment")
public interface DeparmentController {
    @PostMapping("/add")
    public ResponseEntity<DeparmentDTO> createDeparment(@RequestBody DeparmentDTO deparmentDTO) throws ParseException;
    @GetMapping("/searchBy")
    public ResponseEntity<?> getDeparments(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                      @RequestParam(name = "pageSize", required = false,  defaultValue = "100") Integer pageSize,
                                      @RequestParam(name = "sortBy", required = false,  defaultValue = "id") String sortBy);
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDeparment(@PathVariable int id);
}
