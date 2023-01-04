package com.system.response;

import java.util.List;

import lombok.Data;

@Data
public class ObjMapperEgHierarchyResponse {

	private int noOfLevels;
	private List<String> levels;
}
