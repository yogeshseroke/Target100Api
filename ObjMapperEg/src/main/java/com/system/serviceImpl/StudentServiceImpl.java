package com.system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.StudentEntity;
import com.system.entity.SubjectEntity;
import com.system.repository.StudentRepository;
import com.system.repository.SubjectRepository;
import com.system.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public StudentEntity saveStudent(StudentEntity studentEntity) {
		return studentRepository.save(studentEntity);
	}

	@Override
	public Optional<StudentEntity> getStudent(Long student_Id) {
		//Optional<StudentEntity> studentEntity = studentRepository.findById(student_Id);
		Optional<StudentEntity> studentEntity = studentRepository.findByStudentId(student_Id);
		return studentEntity;
	}

	@Override
	public List<StudentEntity> saveListStudent(List<StudentEntity> studentEntity) {
		return studentRepository.saveAll(studentEntity);
	}

	@Override
	public String deleteStudent(Long id) {
		studentRepository.deleteById(id);
		return "deleted Successfully";
	}

}
