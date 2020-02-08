package com.rollforinitiative.campaignmgr.repository;

import com.rollforinitiative.campaignmgr.model.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<PlayerCharacter, Long> {
    List<PlayerCharacter> findByCampaign_campaignId(Long campaignId);
    List<PlayerCharacter> findByOwner_usersId(Long usersId);
    List<PlayerCharacter> findByParty_partyId(Long partyId);


}
