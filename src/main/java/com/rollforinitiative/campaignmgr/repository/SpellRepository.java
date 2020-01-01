package com.rollforinitiative.campaignmgr.repository;

import com.rollforinitiative.campaignmgr.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellRepository extends JpaRepository<Spell, Long> {
}
