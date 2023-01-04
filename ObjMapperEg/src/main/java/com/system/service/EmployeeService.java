package com.system.service;

import java.util.List;

import com.system.entity.EmployeeEntity;

public interface EmployeeService {

	EmployeeEntity saveEmpData(EmployeeEntity employeeEntity);

	EmployeeEntity getEmpByID(Long id);

	List<EmployeeEntity> getAllEmpData();

	EmployeeEntity getByEmpLocation(String emp_location);

	String deleteEmpById(Long id);

	List<EmployeeEntity> getEmpByTechnology(String emp_technology);

	List<EmployeeEntity> getEmpByDesignation(String emp_designation);
	
	List<EmployeeEntity> getEmpByCompanyName(String emp_company_name);

	List<EmployeeEntity> getEmpByName(String emp_name);

	List<EmployeeEntity> getEmpByPackage(String emp_package);

	List<EmployeeEntity> saveListOfEmp(List<EmployeeEntity> employeeEntity);

//	EmployeeEntity updateEmpInfo(EmployeeEntity employeeEntity);

	EmployeeEntity saveEmpDataWithCompany(EmployeeEntity employeeEntity);

}
