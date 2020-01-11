package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.exception.CampaignNotFoundException;
import com.rollforinitiative.campaignmgr.model.Campaign;
import com.rollforinitiative.campaignmgr.model.Image;
import com.rollforinitiative.campaignmgr.model.Users;
import com.rollforinitiative.campaignmgr.repository.CampaignRepository;
import com.rollforinitiative.campaignmgr.repository.UsersRepository;
import com.rollforinitiative.campaignmgr.request.CampaignRequest;

import com.rollforinitiative.campaignmgr.response.CampaignResponse;
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
    @Autowired
    private ImageService imageService;

    @Transactional
    public List<CampaignResponse> getAllCampaigns() {
        List<Campaign> campaigns = campaignRepository.findAll();
        return campaigns.stream().map(this::mapFromCampaignToResponse).collect(toList());
    }

    @Transactional
    public List<CampaignResponse> getAllCampaignsByUsername(String username) {
        List<Campaign> campaigns = campaignRepository.findByOwner_Username(username);
        return campaigns.stream().map(this::mapFromCampaignToResponse).collect(toList());
    }

    @Transactional
    public void createCampaign(CampaignRequest campaignRequest) {
        Campaign campaign = mapFromRequestToCampaign(campaignRequest);
        campaignRepository.save(campaign);
    }

    @Transactional
    public CampaignResponse getCampaignById(Long campaignId) {
        Campaign campaign = campaignRepository.findById(campaignId).orElseThrow(() ->
                new CampaignNotFoundException("For campaign ID: " + campaignId));
        return mapFromCampaignToResponse(campaign);
    }

//    private CampaignRequest mapFromCampaignToRequest(Campaign campaign) {
//        CampaignRequest campaignRequest = new CampaignRequest();
//        campaignRequest.setCampaignId(campaign.getCampaignId());
//        campaignRequest.setCampaignName(campaign.getCampaignName());
//        campaignRequest.setDescription(campaign.getDescription());
//        campaignRequest.setEdition(campaign.getEdition());
//        campaignRequest.setOwner(campaign.getOwner());
//        return campaignRequest;
//    }

    private CampaignResponse mapFromCampaignToResponse(Campaign campaign) {
        CampaignResponse campaignResponse = new CampaignResponse();
        campaignResponse.setCampaignId(campaign.getCampaignId());
        campaignResponse.setCampaignName(campaign.getCampaignName());
        campaignResponse.setDescription(campaign.getDescription());
        campaignResponse.setEdition(campaign.getEdition());
        campaignResponse.setOwner(campaign.getOwner().getUsername());
        campaignResponse.setCampaignImage(campaign.getCampaignPicture());
//        campaignResponse.setWorldMap(campaign.getWorldMap());
        return campaignResponse;
    }

//    private CampaignLessOwnerRequest mapFromCampaignToRequestLessOwner(Campaign campaign) {
//        CampaignLessOwnerRequest campaignLessOwnerRequest = new CampaignLessOwnerRequest();
//        campaignLessOwnerRequest.setCampaignId(campaign.getCampaignId());
//        campaignLessOwnerRequest.setCampaignName(campaign.getCampaignName());
//        campaignLessOwnerRequest.setDescription(campaign.getDescription());
//        campaignLessOwnerRequest.setEdition(campaign.getEdition());
//        return campaignLessOwnerRequest;
//    }

    private Campaign mapFromRequestToCampaign(CampaignRequest campaignRequest) {
        Campaign campaign = new Campaign();
        campaign.setCampaignName(campaignRequest.getCampaignName());
        campaign.setDescription(campaignRequest.getDescription());
        campaign.setEdition(campaignRequest.getEdition());

        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User not found."));
        Users owner = usersRepository.findByUsername(loggedInUser.getUsername()).get();
        campaign.setOwner(owner);

        Image campaignPicture = imageService.storeImage(campaignRequest.getCampaignImage());
//        Image worldMap = imageService.storeImage(campaignRequest.getWorldMap());

        campaign.setCampaignPicture(campaignPicture);
//        campaign.setWorldMap(worldMap);

        return campaign;
    }

    @Transactional
    public Boolean deleteCampaignById(Long campaignId) {
        campaignRepository.deleteById(campaignId);
        return true;
    }

//    @Transactional
//    public Campaign updateCampaign(CampaignRequest campaignRequest) {
//        Campaign campaign = campaignRepository.getOne(campaignRequest.getCampaignId());
//        campaign.setCampaignName(campaignRequest.getCampaignName());
//        campaign.setDescription(campaignRequest.getDescription());
//        campaign.setEdition(campaignRequest.getEdition());
//        campaignRepository.save(campaign);
//        return campaign;
//    }

}
