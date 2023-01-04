package com.system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.entity.CategoryEntity;
import com.system.repository.*;
import com.system.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired(required = false)
	CategoryRepository categoryRepository;

	@Override
	public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
		
		return categoryRepository.save(categoryEntity);
	}

	@Override
	public CategoryEntity getCategory(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public List<CategoryEntity> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public String deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		return null;
	}

	@Override
	public CategoryEntity updateCategory(CategoryEntity categoryEntity) {
		CategoryEntity categoryEntity2 = categoryRepository.findById(categoryEntity.getCId()).orElse(null);
		categoryEntity2.setCId(categoryEntity.getCId());
		categoryEntity2.setCName(categoryEntity.getCName());
		return categoryEntity2;
	}

	@Override
	public List<CategoryEntity> saveListCategory(List<CategoryEntity> categoryEntities) {
		return categoryRepository.saveAll(categoryEntities);
	}

	@Override
	public CategoryEntity getByCategoryName(String cName) {
		return categoryRepository.findByCategoryName(cName);
	}

}
