package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.CountryDAO;
import com.cognizant.exception.CountryNotFoundException;
import com.cognizant.model.Country;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CountryService {

	@Autowired
	CountryDAO dao;
	
	public List<Country> getCountries(){
		log.info("\nstart");
		List<Country> countries=dao.countries;
		log.debug("\nCountries are:{}",countries);
		log.info("\nEnd");
		return countries;
	}
	
	public Country getCountryIndia() throws CountryNotFoundException{
		log.info("\nstart");
		Country country=dao.getCountry("in");
		log.debug("\nCountry is:{}",country);
		log.info("\nEnd");
		return country;
	}
	
	
	public Country getCountryByCode(String code) throws CountryNotFoundException{
		log.info("\nstart");
		Country country=dao.getCountry(code);
		log.debug("\nCountry is:{}",country);
		log.info("\nEnd");
		return country;
	}
	
	
	public Country deleteCountryByCode(String code) throws CountryNotFoundException{
		log.info("\nstart");
		Country country=dao.deleteCountry(code);
		log.debug("\nDeleted Country is:{}",country);
		log.info("\nEnd");
		return country;
	}

	
	public Country updateCountry(Country c) throws CountryNotFoundException{
		log.info("\nstart");
		Country country=dao.updateCountry(c);
		log.debug("\nUpdated Country is :{}",country);
		log.info("\nEnd");
		return country;
	}
	
	public Country addCountry(Country c){
		log.info("\nstart");
		Country country=dao.addCountry(c);
		log.debug("\nnewly added Country is :{}",country);
		log.info("\nEnd");
		return country;
	}

}
