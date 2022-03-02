package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.exception.CountryNotFoundException;
import com.cognizant.model.Country;

@Repository
public class CountryDAO {

	static public List<Country> countries =new ArrayList<Country>();
	
	public CountryDAO() {
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		countries=context.getBean("countryList",ArrayList.class);
	}
	
	public Country addCountry(Country country) {
		countries.add(country);
		return country;
	}
	
	
	public Country updateCountry(Country country) throws CountryNotFoundException {
		for (Country c : countries) {
			if(c.getCode().equals(country.getCode())) {
				countries.remove(c);
				countries.add(country);
				return country;
			}
		}
		throw new CountryNotFoundException();
		
	}
	
	public Country getCountry(String code) throws CountryNotFoundException {
		for (Country c : countries) {
			if(c.getCode().equalsIgnoreCase(code)) {
				
				return c;
			}
		}
		throw new CountryNotFoundException();
		
	}
	
	
	
	public Country deleteCountry(String code) throws CountryNotFoundException {
		for (Country c : countries) {
			if(c.getCode().equalsIgnoreCase(code)) {
				countries.remove(c);
				return c;
			}
		}
		throw new CountryNotFoundException();
		
	}
}
