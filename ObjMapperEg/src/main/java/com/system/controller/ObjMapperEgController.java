package com.system.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.system.entity.ObjMapperEgEntity;
import com.system.objMapperEgDTO.ObjMapperEgDTO;
import com.system.response.ObjMapperEgHierarchyResponse;
import com.system.response.ObjMapperEgResponse;
import com.system.service.ObjMapperEgService;

@RestController
public class ObjMapperEgController {

	@Autowired
	ObjMapperEgService objMapperEgService;
	
	@Autowired
	ModelMapper modelMapper;
	
	public ObjMapperEgHierarchyResponse objMapperEgHierarchyResponse;
	
	@PostMapping("/saveData")
	public ObjMapperEgEntity saveData(@RequestBody ObjMapperEgEntity objMapperEgEntity) {
		ObjMapperEgEntity save_Data =  objMapperEgService.saveObjectMapperEntity(objMapperEgEntity);
		return save_Data;
	}
	
	@GetMapping("/getData/{id}")
	public ObjMapperEgEntity getDataById(@PathVariable Long id) {
		ObjMapperEgEntity get_Data = objMapperEgService.getObjectMapperEntity(id);
		return get_Data;
	}
	
	@GetMapping("/getListOfData")
	public List<ObjMapperEgEntity> getListOfData(){
		List<ObjMapperEgEntity> get_List_Of_Data = objMapperEgService.getListOfObjectMapperEntity();
		return get_List_Of_Data;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		return objMapperEgService.delete(id);
	}
	
	@PutMapping("/update")
	public ObjMapperEgEntity updateById(@RequestBody ObjMapperEgEntity objMapperEgEntity) {
		return objMapperEgService.updateByID(objMapperEgEntity);
	}
	
	@PostMapping("/save_list_of_data")
	public List<ObjMapperEgEntity> saveListOfData(@RequestBody List<ObjMapperEgEntity> objMapperEgEntities) {
		return objMapperEgService.saveListOfObjectMapperEntity(objMapperEgEntities);
	}
	
	@GetMapping("/exist_By_Id/{id}")
	public boolean dataExist(@PathVariable Long id) {
		return objMapperEgService.existById(id);
	}
	
	@GetMapping("/get_by_name/{name}")
	public boolean getByName(@PathVariable String name) {
		return objMapperEgService.existByName(name);
	}
	
	@GetMapping("/get_by_id_and_name/{id}/{name}")
	public ObjMapperEgEntity getByIdAndName(@PathVariable Long id, @PathVariable String name) {
		ObjMapperEgEntity objMapperEgEntity =  objMapperEgService.getByIdAndName(id, name);
		return objMapperEgEntity;
	}
	
	@GetMapping("/exist_address/{address}")
	public ObjMapperEgEntity existByAddress(@PathVariable String address) {
		ObjMapperEgEntity objMapperEgEntity = objMapperEgService.existByAddress(address);
		return objMapperEgEntity;
	}
	
	@GetMapping("/delete_all")
	public String deleteAll() {
		return objMapperEgService.delete_All();
	}
	
	//ye api akash ke naam...
	@PostMapping("/saveAkash")
	public ObjMapperEgEntity saveAkash(@RequestBody ObjMapperEgEntity objMapperEgEntity) {
		return objMapperEgService.saveAkash(objMapperEgEntity);
		
	}
	
//	@PostMapping("/saveDTO")
//	public List<ObjMapperEgEntity> saveDTO(@RequestBody ObjMapperEgDTO objMapperEgDTO) {
//		List<ObjMapperEgEntity> ltsOfDto = objMapperEgService.saveDTO(objMapperEgDTO);
//		return ltsOfDto;	
//	}
	
	@PostMapping("/saveDTO")
	public ResponseEntity<ObjMapperEgDTO> saveDTO(@RequestBody ObjMapperEgDTO objMapperEgDTO ){
		/*// convert DTO to entity
		   Post postRequest = modelMapper.map(postDto, Post.class);
		   Post post = postService.createPost(postRequest);
		
		   // convert entity to DTO
		PostDto postResponse = modelMapper.map(post, PostDto.class);

		return new ResponseEntity<PostDto>(postResponse, HttpStatus.CREATED);	
		*/
		ObjMapperEgEntity objMapperEgEntity = modelMapper.map(objMapperEgDTO, ObjMapperEgEntity.class);
		ObjMapperEgEntity objMapperEgEntity2 = objMapperEgService.createPost(objMapperEgEntity);
		
		ObjMapperEgDTO objMapperEgDTO2 = modelMapper.map(objMapperEgEntity2, ObjMapperEgDTO.class);
		return new ResponseEntity<ObjMapperEgDTO>(objMapperEgDTO2, HttpStatus.CREATED);
	}
	
	//api for csv file...
	
	//@GetMapping(path = "v1/downloadTemplate/{id}", produces = { "application/csv" })
	@GetMapping("v1/downloadTemplate/{id}")
	public ResponseEntity<InputStreamResource> downloadTemplate(@PathVariable Long id) {
		String filename = id + ".csv";
		InputStreamResource file = objMapperEgService.getCSVTemplateDownload(objMapperEgHierarchyResponse);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
				.contentType(MediaType.parseMediaType("application/csv")).body(file);
	}
}
