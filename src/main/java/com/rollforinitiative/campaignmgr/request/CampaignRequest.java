package com.rollforinitiative.campaignmgr.request;

import com.rollforinitiative.campaignmgr.model.Users;
import org.springframework.security.core.userdetails.User;

public class CampaignRequest {
    private Long campaignId;
    private String campaignName;
    private Double edition;
    private String description;
    private Users owner;

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
}
