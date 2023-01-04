package com.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.entity.ObjMapperEgEntity;
import com.system.objMapperEgDTO.ObjMapperEgDTO;

@Repository
public interface ObjMapperEgRepository extends JpaRepository<ObjMapperEgEntity, Long>{

	
	boolean existsByName(String name);

//	Object getBYIdAndName(Long id, String name);
 //  @Query(value = "select * from obj_mapper_entity where id = ?1 and name = ?2",nativeQuery = true)
	ObjMapperEgEntity findByIdAndName(Long id, String name);

   
   	ObjMapperEgEntity findByAddress(String address);

	List<ObjMapperEgEntity> save(ObjMapperEgDTO objMapperEgDTO);
	 
}
