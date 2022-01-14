package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "deparment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Deparment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

//    @Column(name = "date_create")
//    private Date date;


    @OneToMany(mappedBy = "deparment")
    //    cascade = CascadeType.ALL,
    private List<User> userList = new ArrayList<>();

}





