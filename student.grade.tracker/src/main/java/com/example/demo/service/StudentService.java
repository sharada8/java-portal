package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public List<Teacher> listAll(){
		return repo.findAll();
	}

	public void save(Teacher teacher) {
		repo.save(teacher);
		// TODO Auto-generated method stub
		
	}

	public Teacher get(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
		// TODO Auto-generated method stub
		
	}


}
