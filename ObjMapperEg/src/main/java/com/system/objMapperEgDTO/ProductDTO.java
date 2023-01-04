package com.system.objMapperEgDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductDTO {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productDTOId;
	
	private Boolean isFavourite;
	
	private Long pId;


}
