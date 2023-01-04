package com.system.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.entity.CompanyEntity;
import com.system.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	CompanyService companyService;
	
	@PostMapping("/save_company")
	public CompanyEntity saveCompany(@RequestBody CompanyEntity companyEntity) {
		return companyService.saveCompany(companyEntity);
	}
	
	@GetMapping("/get_company/{companyId}")
	public Optional<CompanyEntity> getCompany(@RequestParam Long companyId) {
		return companyService.getCompany(companyId);
	}
}
