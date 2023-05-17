package com.example.demo.info;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.info.model.City;
import com.example.demo.info.model.TestModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("info")
public class InfoController {

	
	//test
	//@Autowired //여기에 @Autowired 해도 되지만 생성자 만들어서 쓰는걸 추천한다고 한다(순환참조 방지 등...)
	private InfoService infoService;
	
	@Autowired  // spring 4.3 버전 이상부터는 생략 가능
	public InfoController(InfoService infoService) {
		log.debug("InfoController start!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		this.infoService = infoService;
	}
	
	
	//서비스에서 초기화한 값 가져오기
	@GetMapping("/service")
	public Object projectInfo() {
		TestModel testModel = new TestModel();
		testModel = infoService.gettestInfo();
		return testModel;
	}

	//직접 컨트롤러 안에서 값 넣기
	@GetMapping("/gson")
	public String customJson() {
		JsonObject jo = new JsonObject();
		jo.addProperty("projectName", "preword");
		jo.addProperty("author", "hello-bryan");
		jo.addProperty("createdDate", new Date().toString());
		
		JsonArray ja = new JsonArray();
		for(int i=0; i<5; i++) {
			JsonObject jObj = new JsonObject();
			jObj.addProperty("prop"+i, i);
			ja.add(jObj);
		}
		jo.add("follower", ja);
		return jo.toString();
	}
	
	
	
	
	//================================================================================//
	//=================================  select test =================================//
	//================================================================================//
	// DB(groovy) 테스트
	@GetMapping("/cityList")
	public Object cityList() {
		log.debug("/cityList start");
		List<City> cityList = infoService.getCityList();
		return cityList;
	}
	
	
//	// @RequestParam으로 받는법
//	@GetMapping("cityByCountryCode")
//	public Object cityByCountryCode(@RequestParam("countryCode") String ctCode
//			, @RequestParam(value="population", required = false, defaultValue = "0") int population) {
//		log.debug("countryCode = {}, population = {}", ctCode, population);
//		List<City> cityList = infoService.findCityByCodeAndPopulation(ctCode, population);
//		return cityList;
//	}
	
	// @PathVariable로 받는법
	@GetMapping("cityByCountryCode/{countryCode}/{population}")
	public Object cityByCountryCode(
			@PathVariable("countryCode") String ctCode,
			@PathVariable("population") int population) {
		log.debug("/cityByCountryCode start");
		log.debug("countryCode = {}, population = {}", ctCode, population);
		List<City> cityList = infoService.findCityByCodeAndPopulation(ctCode, population);
//		List<City> cityList = null;
		return cityList;
	}
	
	
	
	// Post도 한번
	@PostMapping(value="cityAdd")
	public ResponseEntity<City> cityAdd(@RequestBody City city) {
		log.debug("city = {}", city.toString());
		return new ResponseEntity<>(city, HttpStatus.OK);
	}
	
	
	
	
	//================================================================================//
	//=================================  insert test =================================//
	//================================================================================//
	
//	// 기본 구조
//	@GetMapping(value="cityAdd")
//	public Object cityAdd(City city) {
//		log.debug("city = {}", city.toString());
//		return city.toString();
//	}
	
	
	
	
	
//	@GetMapping("cityAdd/{name}/{countryCode}/{district}/{population}")
//	public Object cityAdd(@PathVariable(value="name") String name
//			, @PathVariable(value="countryCode") String ctCode
//			, @PathVariable(value="district") String district
//			, @PathVariable(value="population") int population) {
//		
//		log.debug("name = {}, ctCode = {}, district = {}, population ={}", name, ctCode, district, population);
//		
//		return "ok";
//	}
//	@GetMapping(value="cityAdd")
//	public Object cityAdd(City city) {
//		log.debug("city = {}", city.toString());
//		return "ok";
//	}
}
