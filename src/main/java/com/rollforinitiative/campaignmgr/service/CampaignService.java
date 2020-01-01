package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.exception.CampaignNotFoundException;
import com.rollforinitiative.campaignmgr.model.Campaign;
import com.rollforinitiative.campaignmgr.model.Users;
import com.rollforinitiative.campaignmgr.repository.CampaignRepository;
import com.rollforinitiative.campaignmgr.repository.UsersRepository;
import com.rollforinitiative.campaignmgr.request.CampaignRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class CampaignService {

    @Autowired
    private AuthService authService;
    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public List<CampaignRequest> getAllCampaigns() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaigns.stream().map(this::mapFromCampaignToRequest).collect(toList());
    }

    @Transactional
    public Campaign createCampaign(CampaignRequest campaignRequest) {
        Campaign campaign = mapFromRequestToCampaign(campaignRequest);
        campaignRepository.save(campaign);
        return campaign;
    }

    @Transactional
    public CampaignRequest getCampaignById(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() ->
                new CampaignNotFoundException("For campaign ID: " + campaignId));
        return mapFromCampaignToRequest(campaign);
    }

    private CampaignRequest mapFromCampaignToRequest(Campaign campaign) {
        CampaignRequest campaignRequest = new CampaignRequest();
        campaignRequest.setCampaignId(campaign.getCampaignId());
        campaignRequest.setCampaignName(campaign.getCampaignName());
        campaignRequest.setDescription(campaign.getDescription());
        campaignRequest.setEdition(campaign.getEdition());
        campaignRequest.setOwner(campaign.getOwner());
        return campaignRequest;
    }

    private Campaign mapFromRequestToCampaign(CampaignRequest campaignRequest) {
        Campaign campaign = new Campaign();
        campaign.setCampaignId(campaignRequest.getCampaignId());
        campaign.setCampaignName(campaignRequest.getCampaignName());
        campaign.setDescription(campaignRequest.getDescription());
        campaign.setEdition(campaignRequest.getEdition());

        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User not found."));
        String ownerUsername = loggedInUser.getUsername();
        Optional<Users> owner = usersRepository.findByUsername(ownerUsername);
        campaign.setOwner(owner.get());

        return campaign;
    }

    @Transactional
    public void deleteCampaignById(Long campaignId) {
        campaignRepository.deleteById(campaignId);
    }

    @Transactional
    public void updateCampaign(CampaignRequest campaignRequest) {
        Campaign campaign = campaignRepository.getOne(campaignRequest.getCampaignId());
        campaign.setCampaignName(campaignRequest.getCampaignName());
        campaign.setDescription(campaignRequest.getDescription());
        campaign.setEdition(campaignRequest.getEdition());
        campaignRepository.save(campaign);
    }

}
