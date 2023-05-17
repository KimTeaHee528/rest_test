package com.example.demo.info.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@JsonInclude(JsonInclude.Include.NON_NULL) 이거 쓰면 Null은 리턴 안함
public class TestModel {
	
//	@JsonProperty(value = "testName") 쓰면 필드이름 바꿔서 보여줌
	@JsonProperty(value = "testModel")
	public String projectName;
	public int testId;
	public String testLastName;
	//@JsonIgnore쓰면 리턴에 포함 안됨
	@JsonIgnore
	public String testIgnore;
	
	
}
