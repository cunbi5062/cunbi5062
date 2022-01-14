package com.example.test.controller.impl;

import com.example.test.controller.UserController;
import com.example.test.entity.User;
import com.example.test.model.DeparmentDTO;
import com.example.test.model.UserDTO;
import com.example.test.model.UserPassDTO;
import com.example.test.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor

public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<?> searchUser(String keyword) {
        List<UserDTO> userDTOList = userService.searchUser(keyword);
        return ResponseEntity.ok(userDTOList);
    }

    @Override
    public ResponseEntity<?> searchUserAll() {
        List<User> userDTOS = userService.getListUser();
        return ResponseEntity.ok(userDTOS);
    }

    @Override
    public ResponseEntity<?> getUserById(int id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserPassDTO userPassDTO) {

        UserDTO response = userService.insert(userPassDTO);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> updateUser(User user) {
        userService.update(user);
        return ResponseEntity.ok(user);

    }

    @Override
    public ResponseEntity<?> deleteUser(int id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> getUsers(Integer pageNo, Integer pageSize, String sortBy) {
        List<UserDTO> userDTOList = userService.getUsers(pageNo ,pageSize,sortBy);
        return ResponseEntity.ok(userDTOList);

    }
}
