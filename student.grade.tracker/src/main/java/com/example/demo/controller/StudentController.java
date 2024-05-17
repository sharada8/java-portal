	package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Teacher;
import com.example.demo.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;
	@GetMapping("/")
	public String viewhomepage(Model model) {
		List<Teacher> listteacher = service.listAll();
		model.addAttribute("listteacher", listteacher);
		System.out.println("Get/");
		return"index.html";
	}
	
	@RequestMapping("/teacherauthentication")
	public String teacherauthentication() {
		return"teacherauthentication.html";
	}
	
	@RequestMapping("/teacher")
	public String teacher(Model model) {
		List<Teacher> listteacher = service.listAll();
		model.addAttribute("listteacher", listteacher);
		System.out.println("Get/");
	    return "teacher.html";
	}
	
	@RequestMapping("/student")
	public String student(Model model) {
		List<Teacher> listteacher = service.listAll();
		model.addAttribute("listteacher", listteacher);
		System.out.println("Get/");
//	    return "teacher.html";
	    return "student.html";
	}
	
	@RequestMapping("/addstudent")
	public String addStudent(Model model) {
		List<Teacher> listteacher= service.listAll();
		model.addAttribute("listteacher", listteacher);
		model.addAttribute("teacher", new Teacher());
		return"addstudent.html";
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute("teacher") Teacher teacher) {
		service.save(teacher);
//		return new ModelAndView("redirect:/teacher/");
//		return "redirect:/teacher/";
		 return new ModelAndView("redirect:/student/teacher");
		}
	
	@RequestMapping("/edit/{id}")
    public ModelAndView showEditCoursePage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("addstudent");
        Teacher teacher = service.get(id);
        mav.addObject("teacher", teacher);
        return mav;
        
    }
	
	  @RequestMapping("/delete/{id}")
	    public ModelAndView deleteCoursePage(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return new ModelAndView("redirect:/student/teacher");
	    }
	  
//	  @RequestMapping("/graph")
//	  public ModelAndView graph() {
//		  return new ModelAndView("graph");
//	  }
	  
	  @RequestMapping("/graph")
		public String getAllteacher(Model model) {	
		  List<String> stdname=service.getAllteacher().stream().map(x->x.getStudentname()).collect(Collectors.toList());
		  List<Integer> gpa=service.getAllteacher().stream().map(x->x.getGpa()).collect(Collectors.toList());
//			List<Integer> grades = Arrays.asList(10,40,20); 
		model.addAttribute("studentname", stdname);
		model.addAttribute("gpa", gpa);
		return "graph.html";
		
		}
}
