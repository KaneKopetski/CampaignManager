package com.rollforinitiative.campaignmgr.repository;

import com.rollforinitiative.campaignmgr.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
