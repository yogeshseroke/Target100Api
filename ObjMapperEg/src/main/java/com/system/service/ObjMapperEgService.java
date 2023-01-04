package com.system.service;

import java.util.List;

import org.springframework.core.io.InputStreamResource;

import com.system.entity.ObjMapperEgEntity;
import com.system.objMapperEgDTO.ObjMapperEgDTO;
import com.system.response.ObjMapperEgHierarchyResponse;
import com.system.response.ObjMapperEgResponse;

public interface ObjMapperEgService {

	public ObjMapperEgEntity saveObjectMapperEntity(ObjMapperEgEntity objMapperEgEntity);
	
	public ObjMapperEgEntity getObjectMapperEntity(Long id);
	
	public List<ObjMapperEgEntity> getListOfObjectMapperEntity();

	public String delete(Long id);

	public ObjMapperEgEntity updateByID(ObjMapperEgEntity objMapperEgEntity);

	public List<ObjMapperEgEntity> saveListOfObjectMapperEntity(List<ObjMapperEgEntity> objMapperEgEntities);

	public boolean existById(Long id);

	public boolean existByName(String name);

	public ObjMapperEgEntity getByIdAndName(Long id, String name);

	public ObjMapperEgEntity existByAddress(String address);

	public String delete_All();

	public ObjMapperEgEntity saveAkash(ObjMapperEgEntity objMapperEgEntity);

	public List<ObjMapperEgEntity> saveDTO(ObjMapperEgDTO objMapperEgDTO);

	public ObjMapperEgEntity createPost(ObjMapperEgEntity objMapperEgEntity);

	public InputStreamResource getCSVTemplateDownload(ObjMapperEgHierarchyResponse objMapperEgHierarchyResponse);
}
