package com.example.test.service;


import com.example.test.entity.User;
import com.example.test.model.UserDTO;
import com.example.test.model.UserPassDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDTO insert(UserPassDTO userPassDTO);

    void update(User user);

    void delete(int id);

    List<User> getListUser();

    public UserDTO getUserById(int id);

    public List<UserDTO> searchUser(String keyword);

    public List<UserDTO> getUsers(Integer pageNo, Integer pageSize, String sortBy);



}
