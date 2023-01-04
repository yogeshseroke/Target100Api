package com.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

	@Query(value = "SELECT * FROM employee_entity WHERE emp_location = ?1", nativeQuery = true)
	EmployeeEntity findByEmpLocation(String emp_location);

	@Query(value = "SELECT * FROM employee_entity WHERE emp_technology = ?1", nativeQuery = true)
	List<EmployeeEntity> findByTechnology(String emp_technology);

	@Query(value = "SELECT * FROM employee_entity WHERE emp_designation = ?1", nativeQuery = true)
	List<EmployeeEntity> findByDesignation(String emp_designation);

	@Query(value = "SELECT * FROM employee_entity WHERE emp_company_name = ?1", nativeQuery = true)
	List<EmployeeEntity> findByCompanyName(String emp_company_name);

	@Query(value = "SELECT * FROM employee_entity WHERE emp_name = ?1", nativeQuery = true)
	List<EmployeeEntity> findByName(String emp_name);

	@Query(value = "SELECT * FROM employee_entity WHERE emp_package = ?1", nativeQuery = true)
	List<EmployeeEntity> findByPackageName(String emp_package);

	
	//EmployeeEntity updateEmpInfo(EmployeeEntity employeeEntity);

}
