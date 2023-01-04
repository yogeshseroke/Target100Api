package com.system.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cId;
	
	private String cName;
	
//	@ManyToMany
//	Set<ProductEntity> productEntity;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name="p_id", nullable=true)
//	private ProductEntity productEntity;
}
