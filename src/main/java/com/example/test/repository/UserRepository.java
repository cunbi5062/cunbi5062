package com.example.test.repository;

import com.example.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.name LIKE %?1%")
    public List<User> findAll(String keyword);
}
