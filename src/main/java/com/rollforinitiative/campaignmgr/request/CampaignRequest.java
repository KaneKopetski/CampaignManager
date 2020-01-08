package com.rollforinitiative.campaignmgr.request;

import com.rollforinitiative.campaignmgr.model.Users;
import org.springframework.web.multipart.MultipartFile;

public class CampaignRequest {
    private Long campaignId;
    private String campaignName;
    private Double edition;
    private String description;
    private Users owner;
    private MultipartFile campaignImage;
    private MultipartFile worldMap;

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

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public MultipartFile getCampaignImage() {
        return campaignImage;
    }

    public void setCampaignImage(MultipartFile campaignImage) {
        this.campaignImage = campaignImage;
    }

    public MultipartFile getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(MultipartFile worldMap) {
        this.worldMap = worldMap;
    }
}
