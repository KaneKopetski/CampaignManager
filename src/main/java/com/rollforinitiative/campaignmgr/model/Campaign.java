package com.rollforinitiative.campaignmgr.model;


import javax.persistence.*;

@Entity
public class Campaign {
    @Id
    @GeneratedValue
    private Long campaignId;
    @Column
    private String campaignName;
    @Column
    private String edition;
    @Column
    private String description;
    @ManyToOne
    private Users owner;
    @OneToOne
    private Image campaignPicture;
    @OneToOne
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

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
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

    public Image getCampaignPicture() {
        return campaignPicture;
    }

    public void setCampaignPicture(Image campaignPicture) {
        this.campaignPicture = campaignPicture;
    }

    public Image getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(Image worldMap) {
        this.worldMap = worldMap;
    }
}
