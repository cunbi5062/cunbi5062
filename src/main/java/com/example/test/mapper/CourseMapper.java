package com.example.test.mapper;

import com.example.test.entity.Course;
import com.example.test.entity.User;
import com.example.test.model.CourseDTO;
import com.example.test.model.UserDTO;
import com.example.test.model.UserLikeCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseMapper {
    @Autowired
    UserMapper userMapper;

    public CourseDTO toCourseDTO(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName(course.getName());

        List<User> userList = course.getUsers();
        List<UserLikeCourseDTO> userLikeCourseDTOList = new ArrayList<>();
        for (User user : userList) {
            UserLikeCourseDTO dto = new UserLikeCourseDTO();
            dto.setName(user.getName());
            userLikeCourseDTOList.add(dto);
        }
        courseDTO.setUserList(userLikeCourseDTOList);

        return courseDTO;
    }
}
