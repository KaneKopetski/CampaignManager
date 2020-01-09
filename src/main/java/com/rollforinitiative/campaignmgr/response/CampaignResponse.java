package com.rollforinitiative.campaignmgr.response;

import com.rollforinitiative.campaignmgr.model.Image;

public class CampaignResponse {
    private Long campaignId;
    private String campaignName;
    private Double edition;
    private String description;
    private String owner;
    private Image campaignImage;
    private Image worldMap;

    public Long getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Image getCampaignImage() {
        return campaignImage;
    }

    public void setCampaignImage(Image campaignImage) {
        this.campaignImage = campaignImage;
    }

    public Image getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(Image worldMap) {
        this.worldMap = worldMap;
    }
}
