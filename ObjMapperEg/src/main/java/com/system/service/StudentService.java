package com.system.service;

import java.util.List;
import java.util.Optional;

import com.system.entity.StudentEntity;

public interface StudentService {

	StudentEntity saveStudent(StudentEntity studentEntity);

	Optional<StudentEntity> getStudent(Long student_Id);

	List<StudentEntity> saveListStudent(List<StudentEntity> studentEntity);

	String deleteStudent(Long id);
		
}
