package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Teacher;

public interface StudentRepository extends JpaRepository<Teacher, Integer> {

}
