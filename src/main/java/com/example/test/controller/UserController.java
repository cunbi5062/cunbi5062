package com.example.test.controller;

import com.example.test.entity.User;
import com.example.test.model.DeparmentDTO;
import com.example.test.model.UserDTO;
import com.example.test.model.UserPassDTO;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserController {


    @GetMapping("/search")
    public ResponseEntity<?> searchUser(@RequestParam(value = "keyword", required = false) String keyword);

    @GetMapping("/searchAll")
    public ResponseEntity<?> searchUserAll();

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id);

    @PostMapping("/add")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserPassDTO userPassDTO);

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user);

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id);
    @GetMapping("/searchBy")
    public ResponseEntity<?> getUsers(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                     @RequestParam(name = "pageSize", required = false,  defaultValue = "100") Integer pageSize,
                                     @RequestParam(name = "sortBy", required = false,  defaultValue = "id") String sortBy);

}
