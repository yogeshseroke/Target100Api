package com.system.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.ProductEntity;
import com.system.objMapperEgDTO.ProductDTO;
import com.system.repository.ProductRepository;
import com.system.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductEntity saveProduct(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}

	@Override
	public Optional<ProductEntity> getProduct(Long id) {
		Optional<ProductEntity> productEntity =  productRepository.findById(id);
		return productEntity;
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void setFavourite(ProductDTO productDTO) {
		Optional<ProductEntity> product = productRepository.findById(productDTO.getPId());
        ProductEntity product1 = new ProductEntity();
        if (product.isPresent()) {
        	product1 = product.get();
        } else {
        	//product1.setPId(productDTO.getPId());
        	product1.setPId(productDTO.getPId());
        }
        product1.setIsFavorite(productDTO.getIsFavourite());
        product1.setFavoriteUpdateDate(new Date(System.currentTimeMillis()));
		productRepository.save(product1);
	}
	
	

}
