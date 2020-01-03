package com.rollforinitiative.campaignmgr.model;

import org.springframework.security.core.userdetails.User;

import javax.persistence.*;

@Entity
public class Campaign {
    @Id
    @GeneratedValue
    private Long campaignId;
    @Column
    private String campaignName;
    @Column
    private Double edition;
    @Column
    private String description;
    @ManyToOne
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
