package com.system.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class ProductEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long pId;
	
	private String pName;

	private Boolean isFavorite;

    private Date favoriteUpdateDate;
}
