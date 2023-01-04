package com.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.entity.SubjectEntity;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long>{

	@Query(value = "SELECT * FROM subject_entity where student_id =?1", nativeQuery = true)
	List<SubjectEntity> findAllByStudentId(Long student_Id);
	
	

}
