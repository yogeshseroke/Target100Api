package com.system.request;

import lombok.Data;

@Data
public class ObjectMapperEgRequest {

	private int pageIndex;
	private int pageSize;
	private String sortFieldStringWithASCOrDESC;
	private String searchValue;
}
