package com.rollforinitiative.campaignmgr.repository;

import com.rollforinitiative.campaignmgr.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRepository extends JpaRepository<Party, Long> {
}
