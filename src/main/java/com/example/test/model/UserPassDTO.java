package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPassDTO {
    private int id;
    private String name;
    private String avatar;
    private String password;
    private DeparmentDTO deparmentDTO;
}
