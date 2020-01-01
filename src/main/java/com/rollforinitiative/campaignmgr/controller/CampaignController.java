package com.rollforinitiative.campaignmgr.controller;

import com.rollforinitiative.campaignmgr.exception.CampaignNotFoundException;
import com.rollforinitiative.campaignmgr.request.CampaignRequest;
import com.rollforinitiative.campaignmgr.service.CampaignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignController.class);

    @Valid
    @GetMapping("/get/all")
    public ResponseEntity<List<CampaignRequest>> getAllCampaigns() {
        List<CampaignRequest> allCampaigns = campaignService.getAllCampaigns();
        return new ResponseEntity<>(allCampaigns, HttpStatus.OK);
    }

    @GetMapping("/get/{campaignId}")
    public ResponseEntity<CampaignRequest> getCampaignById(@PathVariable Long campaignId) {
        return new ResponseEntity<>(campaignService.getCampaignById(campaignId), HttpStatus.OK);
    }

    @GetMapping("/owner/{ownerId}")
    public ResponseEntity getAllCampaignsByOwner(@PathVariable Long ownerId) {
        return new ResponseEntity<>(campaignService.getAllCampaignsByOwner(ownerId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{campaignId}")
    public ResponseEntity<Boolean> deleteCampaign(@PathVariable Long campaignId) {
        campaignService.deleteCampaignById(campaignId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateCampaign(@RequestBody CampaignRequest campaignRequest) throws CampaignNotFoundException {
        String username = campaignRequest.getOwner().getUsername();
        String campaignName = campaignRequest.getCampaignName();
        String description = campaignRequest.getDescription();
        Double edition = campaignRequest.getEdition();
        LOGGER.info("Campaign update request received. Username: {}", username);
        LOGGER.info("Campaign update request received. Name: {}", campaignName);
        LOGGER.info("Campaign update request received. Description: {}", description);
        LOGGER.info("Campaign update request received. Edition: {}", edition);
        try {
            campaignService.updateCampaign(campaignRequest);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createPost(@RequestBody CampaignRequest campaignRequest) {
        String username = campaignRequest.getOwner().getUsername();
        String campaignName = campaignRequest.getCampaignName();
        String description = campaignRequest.getDescription();
        Double edition = campaignRequest.getEdition();
        LOGGER.info("Campaign creation request received. Username: {}", username);
        LOGGER.info("Campaign creation request received. Name: {}", campaignName);
        LOGGER.info("Campaign creation request received. Description: {}", description);
        LOGGER.info("Campaign creation request received. Edition: {}", edition);
        try {
            campaignService.createCampaign(campaignRequest);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
