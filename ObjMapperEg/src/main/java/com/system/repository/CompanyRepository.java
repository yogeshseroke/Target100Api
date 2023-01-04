package com.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>{

}
