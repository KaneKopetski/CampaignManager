package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.exception.CampaignNotFoundException;
import com.rollforinitiative.campaignmgr.exception.PartyNotFoundException;
import com.rollforinitiative.campaignmgr.model.Campaign;
import com.rollforinitiative.campaignmgr.model.Image;
import com.rollforinitiative.campaignmgr.model.Party;
import com.rollforinitiative.campaignmgr.model.Users;
import com.rollforinitiative.campaignmgr.repository.PartyRepository;
import com.rollforinitiative.campaignmgr.repository.UsersRepository;
import com.rollforinitiative.campaignmgr.request.CampaignRequest;
import com.rollforinitiative.campaignmgr.response.CampaignResponse;
import com.rollforinitiative.campaignmgr.response.PartyWithCharactersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PartyService {

    @Autowired
    private AuthService authService;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ImageService imageService;

    @Transactional
    public List<PartyWithCharactersResponse> getAllParties() {
        List<Party> parties = partyRepository.findAll();
        return parties.stream().map(this::mapFromPartyToResponse).collect(toList());
    }

    @Transactional
    public PartyWithCharactersResponse getPartyResponseById(Long partyId) {
        Party party = partyRepository.findById(partyId).orElseThrow(() ->
                new PartyNotFoundException("For party ID: " + partyId));
        return mapFromPartyToResponse(party);
    }

    @Transactional
    public Party getPartyEntityById(Long partyId) {
        return this.partyRepository.findById(partyId).orElseThrow(() ->
                new PartyNotFoundException("For party ID: " + partyId));
    }

    // TODO Finish this service
    // TODO mapping methods needs to be finished
    private PartyWithCharactersResponse mapFromPartyToResponse(Party party) {
        PartyWithCharactersResponse partyWithCharactersResponse = new PartyWithCharactersResponse();

        return partyWithCharactersResponse;
    }

    private Campaign mapFromRequestToCampaign(CampaignRequest campaignRequest) {
        Campaign campaign = new Campaign();
        campaign.setCampaignName(campaignRequest.getCampaignName());
        campaign.setDescription(campaignRequest.getDescription());
        campaign.setEdition(campaignRequest.getEdition());

        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User not found."));
        Users owner = usersRepository.findByUsername(loggedInUser.getUsername()).get();
        campaign.setOwner(owner);

        Image campaignPicture = imageService.storeImage(campaignRequest.getCampaignImage());
        Image worldMap = imageService.storeImage(campaignRequest.getWorldMap());

        campaign.setCampaignPicture(campaignPicture);
        campaign.setWorldMap(worldMap);

        return campaign;
    }


}

