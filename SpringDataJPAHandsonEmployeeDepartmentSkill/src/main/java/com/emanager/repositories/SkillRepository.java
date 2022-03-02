package com.emanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emanager.models.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
