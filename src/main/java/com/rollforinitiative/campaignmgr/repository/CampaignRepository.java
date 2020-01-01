package com.rollforinitiative.campaignmgr.repository;

import com.rollforinitiative.campaignmgr.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findByOwner_UsersId(Long usersId);

}

