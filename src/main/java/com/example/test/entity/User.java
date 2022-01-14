package com.example.test.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "avatar")
    private String avatar;
//    @Column(name = "enable")
//    private boolean enable;

    @ManyToOne
    @JoinColumn(name = "deparment_id")
    private Deparment deparment;

    @ManyToMany
    @JoinTable(name = "user_course",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id" ) ,
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Course> courses = new ArrayList<>();

}





