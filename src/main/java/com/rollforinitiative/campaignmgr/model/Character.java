package com.rollforinitiative.campaignmgr.model;

import javax.persistence.*;

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
//    @Column
//    private CharRace race;
    @Column
    private Integer charLevel;
    @Column
    private Integer strength;
    @Column
    private Integer constitution;
    @Column
    private Integer dexterity;
    @Column
    private Integer wisdom;
    @Column
    private Integer intelligence;
    @Column
    private Integer charisma;
    @Column
    private Integer attack;
    @Column
    private Integer armorClass;
    @Column
    private Integer speed;
//    @ManyToOne
//    private Party party;
//    @ManyToOne
//    private Users owner;

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public String getBackstory() {
        return backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public CharRace getRace() {
//        return race;
//    }
//
//    public void setRace(CharRace race) {
//        this.race = race;
//    }

    public Integer getCharLevel() {
        return charLevel;
    }

    public void setCharLevel(Integer charLevel) {
        this.charLevel = charLevel;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getConstitution() {
        return constitution;
    }

    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getWisdom() {
        return wisdom;
    }

    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getCharisma() {
        return charisma;
    }

    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

//    public Party getParty() {
//        return party;
//    }
//
//    public void setParty(Party party) {
//        this.party = party;
//    }
//
//    public Users getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Users owner) {
//        this.owner = owner;
//    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(Integer armorClass) {
        this.armorClass = armorClass;
    }
}
