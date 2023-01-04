package com.system.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.system.entity.PaginationEntity;
import com.system.objMapperEgDTO.PaginationDTO;
import com.system.repository.PaginationRepository;
import com.system.response.PaginationResponse;
import com.system.service.PaginationService;

@Service
public class PaginationServiceImpl implements PaginationService{

	@Autowired
	private PaginationRepository paginationRepository;
	
	@Override
	public PaginationDTO createPost(PaginationDTO paginationDTO) {
		
		// convert DTO to Entity...
		PaginationEntity paginationEntity = mapToEntity(paginationDTO);
		PaginationEntity newPaginationEntity = paginationRepository.save(paginationEntity);
		
		// convert Entity to DTO...
		PaginationDTO paginationDTO2 = mapToDTO(newPaginationEntity);
		return paginationDTO2;
	}

	private PaginationDTO mapToDTO(PaginationEntity newPaginationEntity) {
		PaginationDTO paginationDTO = new PaginationDTO();
		paginationDTO.setId(newPaginationEntity.getId());
		paginationDTO.setTitle(newPaginationEntity.getTitle());
		paginationDTO.setDescription(newPaginationEntity.getDescription());
		paginationDTO.setContent(newPaginationEntity.getContent());
		return paginationDTO;
	}

	private PaginationEntity mapToEntity(PaginationDTO paginationDTO) {
		PaginationEntity paginationEntity = new PaginationEntity();
		paginationEntity.setId(paginationDTO.getId());
		paginationEntity.setTitle(paginationDTO.getTitle());
		paginationEntity.setDescription(paginationDTO.getDescription());
		paginationEntity.setContent(paginationDTO.getContent());
		return paginationEntity;
	}

	@Override
	public PaginationResponse getAllPagination(int pageNo, int pageSize, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		
		// create pageable instance...
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		
		Page<PaginationEntity> paginationEntity = paginationRepository.findAll(pageable);
		
		// get content for page object...
		List<PaginationEntity> listOfPaginationEntity = paginationEntity.getContent();
		
		List<PaginationDTO> content = listOfPaginationEntity.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
		
		PaginationResponse paginationResponse = new PaginationResponse();
		paginationResponse.setContent(content);
		paginationResponse.setLast(paginationEntity.isLast());
		paginationResponse.setPageNo(paginationEntity.getNumber());
		paginationResponse.setPageSize(paginationEntity.getSize());
		paginationResponse.setTotalElements(paginationEntity.getTotalElements());
		paginationResponse.setTotalPages(paginationEntity.getTotalPages());
		return paginationResponse;
	}

}
