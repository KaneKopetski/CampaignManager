package com.rollforinitiative.campaignmgr.repository;

import com.rollforinitiative.campaignmgr.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
