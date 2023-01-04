package com.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import lombok.extern.slf4j.Slf4j;

import com.system.constant.ProductConstants;
import com.system.entity.ProductEntity;
import com.system.objMapperEgDTO.ProductDTO;
import com.system.service.ProductService;

@Slf4j
@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/saveProduct")
	public ProductEntity saveProduct(@RequestBody ProductEntity productEntity) {
		return productService.saveProduct(productEntity);
	}
	
	@GetMapping("/getProduct/{id}")
	public Optional<ProductEntity> getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}
	
	@GetMapping("/getAllProduct")
	public List<ProductEntity> getAllProduct(){
		
		return productService.getAllProducts();
	}
	
	@PutMapping("/setAsFavourite")
	public void setAsFavourite(@RequestBody ProductDTO productDTO) {
		try {
			//if(StringUtils.isNotEmpty(productDTO.getPId()) && StringUtils.isNotEmpty(productDTO.getPId()))
			  if(StringUtils.isEmpty(productDTO.getPId())) {
				  
				  productService.setFavourite(productDTO);
			  }	else{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ProductConstants.PRODUCT_ID_REQUIRED);  
	            }
		}catch (ResponseStatusException e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
	}
}
