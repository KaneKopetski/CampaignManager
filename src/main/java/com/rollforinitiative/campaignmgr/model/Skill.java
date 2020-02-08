package com.rollforinitiative.campaignmgr.model;

import javax.persistence.*;

@Entity
public class Skill {
    @Id
    @GeneratedValue
    private Long skillId;
    @Column
    private String name;
    @Column
    private String description;
    @ManyToOne
    private PlayerCharacter playerCharacter;

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
}
