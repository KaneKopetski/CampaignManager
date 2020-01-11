package com.rollforinitiative.campaignmgr.request;

import org.springframework.web.multipart.MultipartFile;

public class CampaignRequest {
    private String campaignName;
    private Double edition;
    private String description;
    private MultipartFile campaignImage;
//    private MultipartFile worldMap;

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Double getEdition() {
        return edition;
    }

    public void setEdition(Double edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getCampaignImage() {
        return campaignImage;
    }

    public void setCampaignImage(MultipartFile campaignImage) {
        this.campaignImage = campaignImage;
    }
//
//    public MultipartFile getWorldMap() {
//        return worldMap;
//    }
//
//    public void setWorldMap(MultipartFile worldMap) {
//        this.worldMap = worldMap;
//    }
}
