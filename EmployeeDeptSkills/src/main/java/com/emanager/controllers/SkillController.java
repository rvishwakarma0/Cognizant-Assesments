package com.emanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emanager.models.Skill;
import com.emanager.services.SkillService;

@RestController
@RequestMapping("/skills")
public class SkillController {
	
	@Autowired
	SkillService service;
	
	@GetMapping("/")
	public List<Skill> getAllSkills() {
		return service.getAllSkills();
	}
}
