package com.rollforinitiative.campaignmgr.model;

import javax.persistence.*;

@Entity
public class Spell {
    @Id
    @GeneratedValue
    private Long spellId;
    @Column
    private String name;
    @Column
    private Boolean somaticComponent;
    @Column
    private Boolean vocalComponent;
    @Column
    private Boolean needsMaterialComponent;
    @Column
    private String materialComponentName;
    @Column
    private Boolean focus;
    @Column
    private Boolean divineFocus;
    @Column
    private Boolean gesture;
    @Column
    private String range;
    @Column
    private Double durationInRounds;
    @Column
    private Double durationInMinutes;
    @Column
    private String description;
    @Column
    private Boolean resistable;
    @Column
    private Boolean savingThrow;
    @Column
    private String castingTime;
    @Column
    private String school;
    @Column
    private String effect;
    @ManyToOne
    private Character character;
}
