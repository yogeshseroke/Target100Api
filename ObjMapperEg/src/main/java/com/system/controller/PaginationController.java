package com.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.system.objMapperEgDTO.PaginationDTO;
import com.system.response.PaginationResponse;
import com.system.service.PaginationService;
import com.system.utils.AppConstants;

@RestController
@RequestMapping("/api/pagination")
public class PaginationController {

	@Autowired
	private PaginationService paginationService;
	
	@PostMapping("/post")
	public ResponseEntity<PaginationDTO> createPost(@RequestBody PaginationDTO paginationDTO){
		return new ResponseEntity<> (paginationService.createPost(paginationDTO), HttpStatus.CREATED );
	}
	
	@GetMapping("/get")
	public PaginationResponse getAllPagination(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
												@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
												@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
												@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return paginationService.getAllPagination(pageNo, pageSize, sortBy, sortDir);
	}
}
