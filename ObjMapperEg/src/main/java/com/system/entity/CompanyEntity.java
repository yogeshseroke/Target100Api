package com.system.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long companyId;
	
	private String companyName;
	
	private String companyLocation;
	
	private String companyProduct;
	
	@OneToOne(mappedBy = "companyEntity")
	private EmployeeEntity employeeEntity;
}
