package com.system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.SubjectEntity;
import com.system.repository.SubjectRepository;
import com.system.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public SubjectEntity saveSubject(SubjectEntity subjectEntity) {
		return subjectRepository.save(subjectEntity);
	}

	@Override
	public Optional<SubjectEntity> getSubject(Long subjectId) {
		Optional<SubjectEntity> subjectEntity = subjectRepository.findById(subjectId);
		return subjectEntity;
	}

	@Override
	public List<SubjectEntity> saveListOfSubject(List<SubjectEntity> subjectEntity) {
		return subjectRepository.saveAll(subjectEntity);
	}

}
