package com.system.service;

import java.util.List;
import java.util.Optional;

import com.system.entity.SubjectEntity;

public interface SubjectService {

	SubjectEntity saveSubject(SubjectEntity subjectEntity);

	Optional<SubjectEntity> getSubject(Long subjectId);

	List<SubjectEntity> saveListOfSubject(List<SubjectEntity> subjectEntity);

}
