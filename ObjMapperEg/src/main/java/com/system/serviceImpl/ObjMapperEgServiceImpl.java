package com.system.serviceImpl;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import com.system.entity.ObjMapperEgEntity;
import com.system.objMapperEgDTO.ObjMapperEgDTO;
import com.system.repository.ObjMapperEgRepository;
import com.system.request.ObjectMapperEgRequest;
import com.system.response.ObjMapperEgHierarchyResponse;
import com.system.response.ObjMapperEgResponse;
import com.system.service.ObjMapperEgService;
import com.system.utilities.CSVDownload;

@Service
public class ObjMapperEgServiceImpl implements ObjMapperEgService{

	private String CSV_HEARDER_SORTING_VALUE = "(iD long, address text, age text, city text, country text, email text, mobile text, name text, :objMapperEgHierarchyString) :searchString :sortingString";
	
	@Autowired
	ObjMapperEgRepository objMapperEgRepository;
	
	@Override
	public ObjMapperEgEntity saveObjectMapperEntity(ObjMapperEgEntity objMapperEgEntity) {
		ObjMapperEgEntity objMapperEgEntity2 = objMapperEgRepository.save(objMapperEgEntity);
		return objMapperEgEntity2;
	}

	@Override
	public ObjMapperEgEntity getObjectMapperEntity(Long id) {
		Optional<ObjMapperEgEntity> objMapperEgEntity3 = objMapperEgRepository.findById(id);
		ObjMapperEgEntity objMapperEgEntity4 = objMapperEgEntity3.isPresent() ? objMapperEgEntity3.get() : null;
		return objMapperEgEntity4;
	}

	@Override
	public List<ObjMapperEgEntity> getListOfObjectMapperEntity() {
		List<ObjMapperEgEntity> objMapperEgEntities5 = objMapperEgRepository.findAll();
		return objMapperEgEntities5;
	}

	@Override
	public String delete(Long id) {
		objMapperEgRepository.deleteById(id);
		return "delete successfull";
	}

//	@Override
//	public ObjMapperEgEntity update_By_ID(Long id) {
//		Optional<ObjMapperEgEntity> updateData = objMapperEgRepository.findById(id);
//		ObjMapperEgEntity objMapperEgEntity = updateData.isPresent() ? updateData.get() : null;
//		objMapperEgEntity.setName(objMapperEgEntity.getName());
//		objMapperEgEntity.setCity(objMapperEgEntity.getCity());
//		objMapperEgEntity.setAge(objMapperEgEntity.getAge());
//		objMapperEgEntity.setAddress(objMapperEgEntity.getAddress());
//		objMapperEgEntity.setCountry(objMapperEgEntity.getCountry());
//		objMapperEgEntity.setEmail(objMapperEgEntity.getEmail());
//		objMapperEgEntity.setMobile(objMapperEgEntity.getMobile());
//		return objMapperEgEntity;
//	}
	
//	public ObjMapperEgEntity update_By_Id(ObjMapperEgEntity objMapperEgEntity) {
//		ObjMapperEgEntity objMapperEgEntity2 = objMapperEgRepository.findById(objMapperEgEntity.getId()).orElse(null);
//		objMapperEgEntity2.setAddress(objMapperEgEntity.getAddress());
//		objMapperEgEntity2.setAge(objMapperEgEntity.getAge());
//		objMapperEgEntity2.setCity(objMapperEgEntity.getCity());
//		objMapperEgEntity2.setCountry(objMapperEgEntity.getCountry());
//		objMapperEgEntity2.setEmail(objMapperEgEntity.getEmail());
//		objMapperEgEntity2.setMobile(objMapperEgEntity.getMobile());
//		objMapperEgEntity2.setName(objMapperEgEntity.getName());
//		return objMapperEgRepository.save(objMapperEgEntity2);
//	}

	@Override
	public ObjMapperEgEntity updateByID(ObjMapperEgEntity objMapperEgEntity) {
		ObjMapperEgEntity objMapperEgEntity2 = objMapperEgRepository.findById(objMapperEgEntity.getId()).orElse(null);
		objMapperEgEntity2.setAddress(objMapperEgEntity.getAddress());
		objMapperEgEntity2.setAge(objMapperEgEntity.getAge());
		objMapperEgEntity2.setCity(objMapperEgEntity.getCity());
		objMapperEgEntity2.setCountry(objMapperEgEntity.getCountry());
		objMapperEgEntity2.setEmail(objMapperEgEntity.getEmail());
		objMapperEgEntity2.setMobile(objMapperEgEntity.getMobile());
		objMapperEgEntity2.setName(objMapperEgEntity.getName());
		return objMapperEgRepository.save(objMapperEgEntity2);
	}

	@Override
	public List<ObjMapperEgEntity> saveListOfObjectMapperEntity(List<ObjMapperEgEntity> objMapperEgEntities) {
		return objMapperEgRepository.saveAll(objMapperEgEntities);
	}

	@Override
	public boolean existById(Long id) {
	   return objMapperEgRepository.existsById(id);
	}

	@Override
	public boolean existByName(String name) {
		return objMapperEgRepository.existsByName(name);
	}

	@Override
	public ObjMapperEgEntity getByIdAndName(Long id, String name) {
		return objMapperEgRepository.findByIdAndName(id,name);	
	}

	@Override
	public ObjMapperEgEntity existByAddress(String address) {
		return objMapperEgRepository.findByAddress(address);
	}

	@Override
	public String delete_All() {
		objMapperEgRepository.deleteAll();
		return "deleted successfully";
	}

	@Override
	public ObjMapperEgEntity saveAkash(ObjMapperEgEntity objMapperEgEntity) {
		return objMapperEgRepository.save(objMapperEgEntity);
	}

	@Override
	public List<ObjMapperEgEntity> saveDTO(ObjMapperEgDTO objMapperEgDTO) {
		return objMapperEgRepository.save(objMapperEgDTO);
	}

	@Override
	public ObjMapperEgEntity createPost(ObjMapperEgEntity objMapperEgEntity) {
		return objMapperEgRepository.save(objMapperEgEntity);
	}

	@Override
	public InputStreamResource getCSVTemplateDownload(ObjMapperEgHierarchyResponse objMapperEgHierarchyResponse) {
		ByteArrayInputStream in = null;
		try {
			ObjectMapperEgRequest ObjectMapperEgRequest = createProductRequest(0, 0, "", "");
			List<Object[]> rowData = new ArrayList<>();
			String listOfHeaderString = getListOfHeaderString(ObjectMapperEgRequest, objMapperEgHierarchyResponse);
			List<String> listOfHeader = getListofHeader(listOfHeaderString);
			in = CSVDownload.objectToCSVCovertoer(listOfHeader, rowData);

		} catch (Exception e) {
			throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
		}
		return new InputStreamResource(in);
	}

	private ObjectMapperEgRequest createProductRequest(int pageIndex, int pageSize, String sortFieldStringWithASCOrDESC, String searchValue) {
		ObjectMapperEgRequest productRequest = new ObjectMapperEgRequest();
		productRequest.setPageIndex(pageIndex);
		productRequest.setPageSize(pageSize);
		productRequest.setSortFieldStringWithASCOrDESC(sortFieldStringWithASCOrDESC);
		productRequest.setSearchValue(searchValue);
		return productRequest;
	}

	private List<String> getListofHeader(String listOfHeaderString) {
		List<String> listOfData = Arrays.asList(listOfHeaderString.replace(":searchString", "").replace("(", "")
				.replace(")", "").replace("int", "").replaceAll("text", "").split("\\s*,\\s*"));
		listOfData.set(listOfData.size() - 1, listOfData.get(listOfData.size() - 1).trim());
		return listOfData;
	}

	private String getListOfHeaderString(ObjectMapperEgRequest objectMapperEgRequest,
			ObjMapperEgHierarchyResponse objMapperEgHierarchyResponse) {
		objectMapperEgRequest = updatePageIndex(objectMapperEgRequest);
		String objMapperEgHierarchyString = objMapperEgHierarchyResponse.getLevels().stream().map(Object::toString)
				.collect(Collectors.joining(" text,")) + " text";
		String sortingString = objectMapperEgRequest.getSortFieldStringWithASCOrDESC();
		String listOfHeaderString = new StringBuilder().append(CSV_HEARDER_SORTING_VALUE
				.replace(":objMapperEgHierarchyString", objMapperEgHierarchyString).replace(":sortingString", sortingString))
				.toString();
		return listOfHeaderString;

	}

	private ObjectMapperEgRequest updatePageIndex(ObjectMapperEgRequest objectMapperEgRequest) {
		int pageIndex = objectMapperEgRequest.getPageIndex() - 1;
		if (pageIndex >= 0) {
			objectMapperEgRequest.setPageIndex(pageIndex);
		} else {
			objectMapperEgRequest.setPageIndex(0);
			objectMapperEgRequest.setPageSize(Integer.MAX_VALUE);
		}
		return objectMapperEgRequest;
	}

	
	
}
