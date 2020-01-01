package com.rollforinitiative.campaignmgr.model;

import javax.persistence.*;

@Entity
public class Party {
    @Id
    @GeneratedValue
    private Long partyId;
    @Column
    private String partyName;
    @Column
    private Integer numberOfPlayers;
    @ManyToOne
    private Campaign campaign;

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }
}
