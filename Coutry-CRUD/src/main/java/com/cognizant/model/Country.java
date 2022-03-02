package com.cognizant.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

	@NotNull
	@Size(min=2, max=2, message="Country code should be 2 characters")
	private String code;
	
	private String name;
	
	
}
