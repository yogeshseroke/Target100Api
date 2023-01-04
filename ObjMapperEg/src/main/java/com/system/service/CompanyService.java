package com.system.service;

import java.util.Optional;

import com.system.entity.CompanyEntity;

public interface CompanyService {

	CompanyEntity saveCompany(CompanyEntity companyEntity);

	Optional<CompanyEntity> getCompany(Long companyId);

}
