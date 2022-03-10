package com.emanager.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanager.models.Skill;
import com.emanager.repositories.SkillRepository;

@Service
public class SkillService {

	@Autowired
	SkillRepository repository;
	
	public Skill get(int id) {
		return repository.findById(id).get();
	}
	@Transactional
	public void save(Skill s) {
		repository.save(s);
	}
	public List<Skill> getAllSkills() {
		
		return repository.findAll();
	}
}
