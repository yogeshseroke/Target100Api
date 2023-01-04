package com.system.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.system.entity.PaginationEntity;

public interface PaginationRepository extends PagingAndSortingRepository<PaginationEntity, Long>{

}
