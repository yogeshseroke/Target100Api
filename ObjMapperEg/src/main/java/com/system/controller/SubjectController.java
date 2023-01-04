package com.system.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.entity.SubjectEntity;
import com.system.service.SubjectService;

@RestController
public class SubjectController {

	@Autowired
	SubjectService subjectService;
	
	@PostMapping("/save_subject")
	public SubjectEntity saveSubject(@RequestBody SubjectEntity subjectEntity) {
		return subjectService.saveSubject(subjectEntity);
	}
	
	@GetMapping("/get_subject/{subjectId}")
	public Optional<SubjectEntity> getSubject(@PathVariable Long subjectId) {
		return subjectService.getSubject(subjectId);
		
	}
	
	@PostMapping("/save_list_subject")
	public List<SubjectEntity> saveListOfSubject(@RequestBody List<SubjectEntity> subjectEntity){
		return subjectService.saveListOfSubject(subjectEntity);
	}
}
