package com.rollforinitiative.campaignmgr.repository;

import com.rollforinitiative.campaignmgr.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
