package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.exception.CampaignNotFoundException;
import com.rollforinitiative.campaignmgr.model.Campaign;
import com.rollforinitiative.campaignmgr.model.Users;
import com.rollforinitiative.campaignmgr.repository.CampaignRepository;
import com.rollforinitiative.campaignmgr.repository.UsersRepository;
import com.rollforinitiative.campaignmgr.request.CampaignLessOwnerRequest;
import com.rollforinitiative.campaignmgr.request.CampaignRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
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
    public List<CampaignLessOwnerRequest> getAllCampaignsByOwner(Long campaignId) {
        List<Campaign> campaigns = campaignRepository.findByOwner_UsersId(campaignId);
        return campaigns.stream().map(this::mapFromCampaignToRequestLessOwner).collect(toList());
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

    private CampaignLessOwnerRequest mapFromCampaignToRequestLessOwner(Campaign campaign) {
        CampaignLessOwnerRequest campaignLessOwnerRequest = new CampaignLessOwnerRequest();
        campaignLessOwnerRequest.setCampaignId(campaign.getCampaignId());
        campaignLessOwnerRequest.setCampaignName(campaign.getCampaignName());
        campaignLessOwnerRequest.setDescription(campaign.getDescription());
        campaignLessOwnerRequest.setEdition(campaign.getEdition());
        return campaignLessOwnerRequest;
    }

    private Campaign mapFromRequestToCampaign(CampaignRequest campaignRequest) {
        Campaign campaign = new Campaign();
        campaign.setCampaignId(campaignRequest.getCampaignId());
        campaign.setCampaignName(campaignRequest.getCampaignName());
        campaign.setDescription(campaignRequest.getDescription());
        campaign.setEdition(campaignRequest.getEdition());

        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User not found."));
        Users owner = usersRepository.findByUsername(loggedInUser.getUsername()).get();
        campaign.setOwner(owner);

        return campaign;
    }

    @Transactional
    public Boolean deleteCampaignById(Long campaignId) {
        campaignRepository.deleteById(campaignId);
        return true;
    }

    @Transactional
    public Campaign updateCampaign(CampaignRequest campaignRequest) {
        Campaign campaign = campaignRepository.getOne(campaignRequest.getCampaignId());
        campaign.setCampaignName(campaignRequest.getCampaignName());
        campaign.setDescription(campaignRequest.getDescription());
        campaign.setEdition(campaignRequest.getEdition());
        campaignRepository.save(campaign);
        return campaign;
    }

}
