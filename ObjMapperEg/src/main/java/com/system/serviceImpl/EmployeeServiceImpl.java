package com.system.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.EmployeeEntity;
import com.system.repository.EmployeeRepository;
import com.system.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeEntity saveEmpData(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}

	@Override
	public EmployeeEntity getEmpByID(Long id) {
		Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
		EmployeeEntity employeeEntity2 = employeeEntity.get();
		return employeeEntity2;
	}

	@Override
	public List<EmployeeEntity> saveListOfEmp(List<EmployeeEntity> employeeEntity) {
		return employeeRepository.saveAll(employeeEntity);
	}

	@Override
	public List<EmployeeEntity> getAllEmpData() {
		return employeeRepository.findAll();
		
	}

	@Override
	public EmployeeEntity getByEmpLocation(String emp_location) {
		EmployeeEntity name = employeeRepository.findByEmpLocation(emp_location);
		return name;
	}

	@Override
	public String deleteEmpById(Long id) {
		 employeeRepository.deleteById(id);
		 return "Deleted Successfully";
	}
	
	@Override
	public List<EmployeeEntity> getEmpByTechnology(String emp_technology) {
		List<EmployeeEntity> technologyName = employeeRepository.findByTechnology(emp_technology);
		return technologyName;
	}
	
	@Override
	public List<EmployeeEntity> getEmpByDesignation(String emp_designation) {
		return employeeRepository.findByDesignation(emp_designation);
	}
		
	@Override
	public List<EmployeeEntity> getEmpByCompanyName(String emp_company_name) {
		return employeeRepository.findByCompanyName(emp_company_name);
	}

	@Override
	public List<EmployeeEntity> getEmpByName(String emp_name) {
		return employeeRepository.findByName(emp_name);
	}

	@Override
	public List<EmployeeEntity> getEmpByPackage(String emp_package) {
		return employeeRepository.findByPackageName(emp_package);
	}

//	@Override
//	public EmployeeEntity updateEmpInfo(EmployeeEntity employeeEntity) {
//		EmployeeEntity employeeEntity2 =  employeeRepository.findById(employeeEntity.getEmpId()).orElse(null);
//		employeeEntity2.setEmpCompanyName(employeeEntity.getEmpCompanyName());
//		employeeEntity2.setEmpDesignation(employeeEntity.getEmpDesignation());
//		employeeEntity2.setEmpLocation(employeeEntity.getEmpLocation());
//		employeeEntity2.setEmpName(employeeEntity.getEmpName());
//		employeeEntity2.setEmpPackage(employeeEntity.getEmpPackage());
//		employeeEntity2.setEmpTechnology(employeeEntity.getEmpTechnology());
//		employeeEntity2.setCompanyEntity(employeeEntity.getCompanyEntity());
//		return employeeRepository.save(employeeEntity2);
//	}

	@Override
	public EmployeeEntity saveEmpDataWithCompany(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}
	
	
}
