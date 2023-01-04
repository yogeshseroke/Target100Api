package com.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.entity.StudentEntity;
import com.system.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/save_student")
	public StudentEntity saveStudent(@RequestBody StudentEntity studentEntity) {
		return studentService.saveStudent(studentEntity);
	}
	
	@GetMapping("/get_student/{studentId}")
	public Optional<StudentEntity> getStudent(@PathVariable Long studentId) {
		return studentService.getStudent(studentId);
		
	}
	
	@PostMapping("/save_list_student")
	public List<StudentEntity> saveListStudent(@RequestBody List<StudentEntity> studentEntity) {
		return studentService.saveListStudent(studentEntity);
	}
	
	@DeleteMapping("/delete_student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}
	
}
