package com.rollforinitiative.campaignmgr.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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
}
