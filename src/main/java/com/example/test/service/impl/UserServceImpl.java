package com.example.test.service.impl;


import com.example.test.entity.Deparment;
import com.example.test.entity.User;
import com.example.test.mapper.UserMapper;
import com.example.test.model.UserDTO;
import com.example.test.model.UserPassDTO;
import com.example.test.repository.UserRepository;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class UserServceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;


    @Override
    public UserDTO insert(UserPassDTO userPassDTO) {
//        UserDTO userDTO = new UserDTO();
        User user = userMapper.toUser(userPassDTO);
        user = userRepository.save(user);
        return userMapper.toUserDTO(user);
    }

    @Override
    public void update(User user) {
        User user2 = userRepository.getById(user.getId());
        if (user != null) {
            user2.setName(user.getName());
            user2.setPassword(user.getPassword());
            user2.setAvatar(user.getAvatar());
            Deparment deparment = new Deparment();
            deparment.setId(user.getDeparment().getId());
            user2.setDeparment(deparment);

            userRepository.save(user2);
        }

    }

    @Override
    public void delete(int id) {
        User user = userRepository.getById(id);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    @Override
    public List<User> getListUser() {
        List<User> users = userRepository.findAll();

        return users;
    }

    @Override
    public UserDTO getUserById(int id) {
        User user = userRepository.getById(id);

        return userMapper.toUserDTO(user);
    }

    @Override
    public List<UserDTO> searchUser(String keyword) {
        List<User> users = userRepository.findAll(keyword);
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(userMapper.toUserDTO(user));
        }
        return userDTOs;
    }

    @Override
    public List<UserDTO> getUsers(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo - 1, pageSize, Sort.by(sortBy).ascending());
        Page<User> result = userRepository.findAll(paging);
        List<UserDTO> finalResult = new ArrayList<>();
        for (User user : result) {
            finalResult.add(userMapper.toUserDTO(user));
        }
        return finalResult;
    }
}

