package com.system.response;

import java.util.List;
import java.util.Optional;

import com.system.entity.ObjMapperEgEntity;

import lombok.Data;

@Data
public class ObjMapperEgResponse {
	private List<String> listOfHearders;
	private List<Object[]> listOfRowData;
	private int pageIndex;
	private int pageSize;
	private int totalElements;
	private int totalPages;
	

}
