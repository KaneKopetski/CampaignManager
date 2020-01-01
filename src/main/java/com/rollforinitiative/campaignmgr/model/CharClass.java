package com.rollforinitiative.campaignmgr.model;

import javax.persistence.*;

@Entity
public class CharClass {
    @Id
    @GeneratedValue
    private Long classId;
    @Column
    private String className;
    @Column
    private String hitDice;
    @ManyToOne
    private Character character;
    @OneToOne
    private Users creator;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Users getCreator() {
        return creator;
    }

    public void setCreator(Users creator) {
        this.creator = creator;
    }

    public String getHitDice() {
        return hitDice;
    }

    public void setHitDice(String hitDice) {
        this.hitDice = hitDice;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
