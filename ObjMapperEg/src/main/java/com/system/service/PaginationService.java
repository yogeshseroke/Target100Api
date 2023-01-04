package com.system.service;

import com.system.objMapperEgDTO.PaginationDTO;
import com.system.response.PaginationResponse;

public interface PaginationService {

	PaginationDTO createPost(PaginationDTO paginationDTO);

	PaginationResponse getAllPagination(int pageNo, int pageSize, String sortBy, String sortDir);

}
