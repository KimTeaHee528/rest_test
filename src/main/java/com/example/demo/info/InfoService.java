package com.example.demo.info;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.info.model.City;
import com.example.demo.info.model.TestModel;
import com.example.demo.info.repository.CityRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InfoService {
	
	private final CityRepository cityRepository;
	
	// spring 4.2 이상은 @Autowired 생략 가능
	public InfoService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
		log.debug("\n@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@\n"
				+  "@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@\n@@@@@@@@@@@@@@@@@@@@@@@\n");
	}
	
	public TestModel gettestInfo() {
		
		TestModel testModel = new TestModel();
		testModel.projectName = "serviceTest";
		testModel.testId = 1111;
		testModel.testLastName = "testLastName";
		testModel.testIgnore = "testIgnore";
		
		return testModel;
	}
	
	public List<City> getCityList() {
		return this.cityRepository.findList();
	}
	
	
	public List<City> findCityByCodeAndPopulation(String countryCode, int population) {
		log.debug("countryCode = {}, population = {}", countryCode, population);
		return this.cityRepository.findByCountryCodeAndPopulation(countryCode, population);
	}
}