package com.system.service;

import java.util.List;
import java.util.Optional;

import com.system.entity.ProductEntity;
import com.system.objMapperEgDTO.ProductDTO;

public interface ProductService {

	ProductEntity saveProduct(ProductEntity productEntity);

	Optional<ProductEntity> getProduct(Long id);

	List<ProductEntity> getAllProducts();
	
	public void setFavourite(ProductDTO productDTO);

}
