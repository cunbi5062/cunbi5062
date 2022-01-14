package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String avatar;
    private String deparmentName;
    //    @JsonManagedReference
    private List<CourseDTO> listCourse;
//    private boolean enable ;

}

