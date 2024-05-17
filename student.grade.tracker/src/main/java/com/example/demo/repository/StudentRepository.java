package com.example.demo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;

import com.example.demo.model.Teacher;

public interface StudentRepository extends JpaRepository<Teacher, Integer> {
	
}
