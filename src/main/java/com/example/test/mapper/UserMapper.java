package com.example.test.mapper;

import com.example.test.entity.Course;
import com.example.test.entity.Deparment;
import com.example.test.entity.User;
import com.example.test.model.CourseDTO;
import com.example.test.model.UserDTO;
import com.example.test.model.UserPassDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public class UserMapper {
    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setDeparmentName(user.getDeparment().getName());

        List<Course> courseList = user.getCourses();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for (Course c : courseList) {
            CourseDTO dto = new CourseDTO();
            dto.setName(c.getName());
            courseDTOList.add(dto);
        }
        userDTO.setListCourse(courseDTOList);
//        userDTO.setEnable(user.isEnable());
        return userDTO;
    }

    public User toUser(UserPassDTO userPassDTO) {
        User user = new User();
        user.setId(userPassDTO.getId());
        user.setName(userPassDTO.getName());
        user.setAvatar(userPassDTO.getAvatar());
        user.setPassword(userPassDTO.getPassword());
        Deparment deparment = new Deparment();
        deparment.setId(userPassDTO.getDeparmentDTO().getId());
        user.setDeparment(deparment);
        return user;

    }
}
