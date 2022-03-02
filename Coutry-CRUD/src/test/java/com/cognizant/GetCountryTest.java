package com.cognizant;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.controller.CountryController;
@SpringBootTest
@AutoConfigureMockMvc
class GetCountryTest {
	
	
	@Autowired
	CountryController countryController;
	
	@Autowired
	private MockMvc mvc;

	
	@Test
	void testGetCountry() throws Exception {
		ResultActions actions = mvc.perform(get("/country"));
		actions.andExpect(status().isOk());
	}
	
	@Test
	void getCountry() throws Exception {
		ResultActions actions = mvc.perform(get("/country"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("IN"));
	}
	
	@Test
	void getCountryException() throws Exception {
		ResultActions actions = mvc.perform(get("/countries/uk"));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Country Not Found"));
	}
}
