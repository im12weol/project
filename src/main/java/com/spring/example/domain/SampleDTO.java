package com.spring.example.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class SampleDTO {
	private List<DTO>list;
	
	public SampleDTO() {
		list=new ArrayList<>();
	}

}
