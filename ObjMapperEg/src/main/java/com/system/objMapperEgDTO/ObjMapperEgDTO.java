package com.system.objMapperEgDTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ObjMapperEgDTO {
	@Id
	private Long id;
	
	private String name;
	
	private String city;
	
	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	  
}
