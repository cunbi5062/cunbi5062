package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeparmentDTO {
    private int id;
    private String name;
    //    private String dateCreate;
    private List<UserLikeCourseDTO> listUser;
}
