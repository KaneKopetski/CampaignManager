package com.rollforinitiative.campaignmgr.controller;

import com.rollforinitiative.campaignmgr.exception.CampaignNotFoundException;
import com.rollforinitiative.campaignmgr.request.CampaignRequest;
import com.rollforinitiative.campaignmgr.response.CampaignResponse;
import com.rollforinitiative.campaignmgr.service.CampaignService;
import com.rollforinitiative.campaignmgr.service.UsersService;
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

    @Autowired
    private UsersService usersService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignController.class);

    @Valid
    @GetMapping("/get/all")
    public ResponseEntity<List<CampaignResponse>> getAllCampaigns() {
        List<CampaignResponse> allCampaigns = campaignService.getAllCampaigns();
        return new ResponseEntity<>(allCampaigns, HttpStatus.OK);
    }

    @GetMapping("/get/{campaignId}")
    public ResponseEntity<CampaignResponse> getCampaignById(@PathVariable Long campaignId) {
        return new ResponseEntity<>(campaignService.getCampaignById(campaignId), HttpStatus.OK);
    }

    @GetMapping("/owner/{username}")
    public ResponseEntity getAllCampaignsByUsername(@PathVariable String username) {
        List<CampaignResponse> allUsersCampaigns = campaignService.getAllCampaignsByUsername(username);
        return new ResponseEntity<>(allUsersCampaigns, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{campaignId}")
    public ResponseEntity deleteCampaign(@PathVariable Long campaignId) {
        LOGGER.info("Deletion request received on: " + campaignId);
        campaignService.deleteCampaignById(campaignId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity createCampaign(@ModelAttribute CampaignRequest campaignRequest) {
        String campaignName = campaignRequest.getCampaignName();
        String description = campaignRequest.getDescription();
        String edition = campaignRequest.getEdition();
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

    @RequestMapping(value="/owner/{username}", method=RequestMethod.OPTIONS)
    public ResponseEntity getOptions(@RequestParam("username") String username) {
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity updateCampaign(@RequestBody CampaignRequest campaignRequest) throws CampaignNotFoundException {
        String campaignName = campaignRequest.getCampaignName();
        String description = campaignRequest.getDescription();
        String edition = campaignRequest.getEdition();
        String imageFileName = campaignRequest.getCampaignImage().getOriginalFilename();
        String worldMapFileName = campaignRequest.getWorldMap().getOriginalFilename();
        LOGGER.info("Campaign update request received.\nName: {}", campaignName);
        LOGGER.info("Description: {}", description);
        LOGGER.info("Edition: {}", edition);
        LOGGER.info("Campaign Image Name: {}", imageFileName);
        LOGGER.info("Campaign World Map Name: {}", worldMapFileName);

        try {
            campaignService.updateCampaign(campaignRequest);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


}
