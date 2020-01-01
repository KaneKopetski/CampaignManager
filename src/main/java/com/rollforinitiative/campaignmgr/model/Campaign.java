package com.rollforinitiative.campaignmgr.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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
}
