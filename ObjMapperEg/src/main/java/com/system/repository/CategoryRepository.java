package com.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{

	@Query(value = "SELECT * FROM category_entity WHERE c_name = ?1", nativeQuery = true)
	CategoryEntity findByCategoryName(String cName);

}
