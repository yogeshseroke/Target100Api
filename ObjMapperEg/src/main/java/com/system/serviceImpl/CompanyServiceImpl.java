package com.system.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.CompanyEntity;
import com.system.repository.CompanyRepository;
import com.system.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	CompanyRepository companyRepository;

	@Override
	public CompanyEntity saveCompany(CompanyEntity companyEntity) {
		return companyRepository.save(companyEntity);
	}

	@Override
	public Optional<CompanyEntity> getCompany(Long companyId) {
		Optional<CompanyEntity> companyEntity =  companyRepository.findById(companyId);
		return companyEntity;
	}

}
