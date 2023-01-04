package com.system.service;

import java.util.List;

import com.system.entity.CategoryEntity;

public interface CategoryService {

	CategoryEntity saveCategory(CategoryEntity categoryEntity);

	CategoryEntity getCategory(Long id);

	List<CategoryEntity> getAllCategory();

	String deleteCategory(Long id);

	CategoryEntity updateCategory(CategoryEntity categoryEntity);

	List<CategoryEntity> saveListCategory(List<CategoryEntity> categoryEntities);

	CategoryEntity getByCategoryName(String cName);

}
