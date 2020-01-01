package com.rollforinitiative.campaignmgr.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Character {
    @Id
    @GeneratedValue
    private Long characterId;
    @Column
    private String backstory;
    @Column
    private Integer age;
    @Column
    private String name;
    @Column
    private String race;
    @Column
    private Integer level;
    @ManyToOne
    private Party party;
    @ManyToOne
    private Users owner;

}
