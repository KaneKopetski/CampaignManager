package com.rollforinitiative.campaignmgr.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CharClass {
    @Id
    @GeneratedValue
    private Long classId;
    @Column
    private String className;
    @Column
    private String hitDice;
    @OneToOne
    private Users creator;
    @ManyToMany(mappedBy = "classes")
    private Set<PlayerCharacter> playerCharacters = new HashSet<>();

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

    public Set<PlayerCharacter> getPlayerCharacters() {
        return playerCharacters;
    }

    public void setPlayerCharacters(Set<PlayerCharacter> playerCharacters) {
        this.playerCharacters = playerCharacters;
    }
}
