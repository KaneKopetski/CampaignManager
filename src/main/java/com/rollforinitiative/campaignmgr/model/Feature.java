package com.rollforinitiative.campaignmgr.model;

import javax.persistence.*;

@Entity
public class Feature {
    @Id
    @GeneratedValue
    private Long featureId;
    @Column
    private String featureName;
    @Column
    private String flavorText;
    @Column
    private String description;
    @ManyToOne
    private Character character;

    public Long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(Long featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
