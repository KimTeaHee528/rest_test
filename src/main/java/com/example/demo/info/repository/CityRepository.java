package com.example.demo.info.repository;

import java.util.List;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.CitySql;
import com.example.demo.info.model.City;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class CityRepository {
	private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private final CityRowMapper cityRowMapper;
	
	public CityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.cityRowMapper = new CityRowMapper();
	}

	public List<City> findList(){
		
		log.debug("findList query = {}", CitySql.SELECT);

//		return null;
		return namedParameterJdbcTemplate.query(CitySql.SELECT
				, EmptySqlParameterSource.INSTANCE
				, this.cityRowMapper);
	}
	
	public List<City> findByCountryCodeAndPopulation(String countryCode, int population){
		
		SqlParameterSource param = new MapSqlParameterSource("countryCode", countryCode)
				.addValue("population1", population);
		String qry = CitySql.SELECT
				+ CitySql.COUNTRY_CODE_CONDITION
				+ CitySql.POPULATION_CONDITION;

		
		return namedParameterJdbcTemplate.query(qry, param, this.cityRowMapper);
	}
}