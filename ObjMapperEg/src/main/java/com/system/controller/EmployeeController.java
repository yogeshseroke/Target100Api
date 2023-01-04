package com.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.entity.EmployeeEntity;
import com.system.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/save_employee")
	public EmployeeEntity saveEmpData(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.saveEmpData(employeeEntity);
	}
	
	@GetMapping("/get_employee/{id}")
	public EmployeeEntity getEmpData(@RequestParam Long id) {
		return employeeService.getEmpByID(id);
	}
	
	@PostMapping("/save_list_emp")
	public List<EmployeeEntity> saveListOfEmp(@RequestBody List<EmployeeEntity> employeeEntity) {
		return employeeService.saveListOfEmp(employeeEntity);
	}
	
	@GetMapping("/get_all_employee")
	public List<EmployeeEntity> getAllEmpData() {
		return employeeService.getAllEmpData();
	}
	
	@GetMapping("/get_emp_by_location/{location_name}")
	public EmployeeEntity getEmpByLocation(@RequestParam String emp_location){
		EmployeeEntity empname = employeeService.getByEmpLocation(emp_location);
		return empname;
	}
	
	@DeleteMapping("/delete_by_id/{id}")
	public String deleteEmpById(@PathVariable Long id) {
		return employeeService.deleteEmpById(id);
	}

	@GetMapping("/get_emp_by_technology/{technology}")
	public List<EmployeeEntity> getEmpByTechnology(@RequestParam String emp_technology){
		return employeeService.getEmpByTechnology(emp_technology);
	}
	
	@GetMapping("/get_emp_by_designation/{designation}")
	public List<EmployeeEntity> getEmpByDesignation(@RequestParam String emp_designation){
		return employeeService.getEmpByDesignation(emp_designation);
	}
		
	@GetMapping("/get_emp_by_companyName/{companyName}")
	public List<EmployeeEntity> getEmpByCompanyName(@RequestParam String emp_company_name){
		return employeeService.getEmpByCompanyName(emp_company_name);
	}
	
	@GetMapping("/get_emp_by_name/{name}")
	public List<EmployeeEntity> getEmpByName(@RequestParam String emp_name){
		return employeeService.getEmpByName(emp_name);
	}
	
	@GetMapping("/get_emp_by_package/{packageName}")
	public List<EmployeeEntity> getEmpByPackage(@RequestParam String emp_package){
		return employeeService.getEmpByPackage(emp_package);
	}
	
//	@PutMapping("/update_emp_info")
//	public EmployeeEntity updateEmpInfo(@RequestBody EmployeeEntity employeeEntity) {
//		return employeeService.updateEmpInfo(employeeEntity);
//	}
	
	@PostMapping("/save_Emp_Data_With_Company")
	public EmployeeEntity saveEmpDataWithCompany(@RequestBody EmployeeEntity employeeEntity) {
		return employeeService.saveEmpDataWithCompany(employeeEntity);
	}
}
