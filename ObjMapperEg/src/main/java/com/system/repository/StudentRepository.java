package com.system.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

	//Query q=s.createQuery("select d.deptid,d.deptname,e.empid,e.empname from student_entity d inner join d.empref e");
	
	@Query(value="select o.subject_id,o.subject_name,e.student_id,e.student_name from student_entity e inner join subject_entity o", nativeQuery=true)
	Optional<StudentEntity> findByStudentId(Long student_Id);

}
