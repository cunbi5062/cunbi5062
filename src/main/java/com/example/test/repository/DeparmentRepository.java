package com.example.test.repository;

import com.example.test.entity.Deparment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeparmentRepository extends JpaRepository<Deparment, Integer> {

}
