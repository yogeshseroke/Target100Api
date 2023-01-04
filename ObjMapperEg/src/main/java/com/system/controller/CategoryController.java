package com.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.entity.CategoryEntity;
import com.system.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save_category")
	public CategoryEntity saveCategory(@RequestBody CategoryEntity categoryEntity) {
		return categoryService.saveCategory(categoryEntity);
	}
	
	@GetMapping("/getCategory/{id}")
	public CategoryEntity getCategory(@PathVariable Long id) {
		return categoryService.getCategory(id);
	}
	
	@GetMapping("/getAllCategory")
	public List<CategoryEntity> getAllCategory() {
		return categoryService.getAllCategory();
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteCategory(@PathVariable Long id) {
		String s=categoryService.deleteCategory(id);
		return "deleted successfully";
	}
	
	@PutMapping("/updateCategory")
	public CategoryEntity updateCategory(@RequestBody CategoryEntity categoryEntity) {
		return categoryService.updateCategory(categoryEntity);
	}
	
	@PostMapping("/saveListOfCategory")
	public List<CategoryEntity> saveListCategory(@RequestBody List<CategoryEntity> categoryEntities){
		return categoryService.saveListCategory(categoryEntities);
	}
	
	@GetMapping("/getByCategoryName/{cName}")
	public CategoryEntity getByCategoryName(@RequestParam String cName) {
		return categoryService.getByCategoryName(cName);
	}
}
