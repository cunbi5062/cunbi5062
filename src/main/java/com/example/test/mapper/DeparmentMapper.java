package com.example.test.mapper;

import com.example.test.entity.Deparment;
import com.example.test.entity.User;
import com.example.test.model.DeparmentDTO;
import com.example.test.model.UserDTO;
import com.example.test.model.UserLikeCourseDTO;
import com.example.test.repository.UserRepository;
//import com.example.test.utils.DateTimeUtils;
import com.example.test.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@Component
public class DeparmentMapper {
    @Autowired
    UserMapper userMapper;

    public DeparmentDTO toDeparmentDTO(Deparment deparment) {
        DeparmentDTO deparmentDTO = new DeparmentDTO();
        deparmentDTO.setId(deparment.getId());
        deparmentDTO.setName(deparment.getName());
//        deparmentDTO.setDateCreate(DateTimeUtils.formatDate(deparment.getDate(), DateTimeUtils.DD_MM_YYYY));
        List<User> userList = deparment.getUserList();
        List<UserLikeCourseDTO> userLikeCourseDTOList = new ArrayList<>();
        for (User user : userList) {
            UserLikeCourseDTO dto = new UserLikeCourseDTO();
            dto.setName(user.getName());
            userLikeCourseDTOList.add(dto);
        }
        deparmentDTO.setListUser(userLikeCourseDTOList);
        return deparmentDTO;
    }

    public Deparment toDeparment(DeparmentDTO deparmentDTO) throws ParseException {
        Deparment deparment = new Deparment();
        deparment.setId(deparmentDTO.getId());
        deparment.setName(deparmentDTO.getName());
        return deparment;
    }
//        Date departdate = new SimpleDateFormat("dd/MM/yyyy").parse(deparmentDTO.getDateCreate());
//        deparment.setDate(departdate);


}
