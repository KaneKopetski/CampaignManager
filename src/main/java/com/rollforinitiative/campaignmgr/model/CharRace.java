package com.rollforinitiative.campaignmgr.model;

import javax.persistence.*;

@Entity
public class CharRace {
    @Id
    @GeneratedValue
    private Long raceId;
    @Column
    private String raceName;
//    @Column
//    private Users creator;
    @Column
    private Integer startingStrength;
    @Column
    private Integer startingConstitution;
    @Column
    private Integer startingDexterity;
    @Column
    private Integer startingWisdom;
    @Column
    private Integer startingIntelligence;
    @Column
    private Integer startingCharisma;

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long raceId) {
        this.raceId = raceId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

//    public Users getCreator() {
//        return creator;
//    }
//
//    public void setCreator(Users creator) {
//        this.creator = creator;
//    }

    public Integer getStartingStrength() {
        return startingStrength;
    }

    public void setStartingStrength(Integer startingStrength) {
        this.startingStrength = startingStrength;
    }

    public Integer getStartingConstitution() {
        return startingConstitution;
    }

    public void setStartingConstitution(Integer startingConstitution) {
        this.startingConstitution = startingConstitution;
    }

    public Integer getStartingDexterity() {
        return startingDexterity;
    }

    public void setStartingDexterity(Integer startingDexterity) {
        this.startingDexterity = startingDexterity;
    }

    public Integer getStartingWisdom() {
        return startingWisdom;
    }

    public void setStartingWisdom(Integer startingWisdom) {
        this.startingWisdom = startingWisdom;
    }

    public Integer getStartingIntelligence() {
        return startingIntelligence;
    }

    public void setStartingIntelligence(Integer startingIntelligence) {
        this.startingIntelligence = startingIntelligence;
    }

    public Integer getStartingCharisma() {
        return startingCharisma;
    }

    public void setStartingCharisma(Integer startingCharisma) {
        this.startingCharisma = startingCharisma;
    }
}
