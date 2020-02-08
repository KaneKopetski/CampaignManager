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
    private Boolean spellResist;
    @Column
    private Boolean savingThrow;
    @Column
    private String castingTime;
    @Column
    private String school;
    @Column
    private String effect;
    @ManyToOne
    private PlayerCharacter playerCharacter;

    public Long getSpellId() {
        return spellId;
    }

    public void setSpellId(Long spellId) {
        this.spellId = spellId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSomaticComponent() {
        return somaticComponent;
    }

    public void setSomaticComponent(Boolean somaticComponent) {
        this.somaticComponent = somaticComponent;
    }

    public Boolean getVocalComponent() {
        return vocalComponent;
    }

    public void setVocalComponent(Boolean vocalComponent) {
        this.vocalComponent = vocalComponent;
    }

    public Boolean getNeedsMaterialComponent() {
        return needsMaterialComponent;
    }

    public void setNeedsMaterialComponent(Boolean needsMaterialComponent) {
        this.needsMaterialComponent = needsMaterialComponent;
    }

    public String getMaterialComponentName() {
        return materialComponentName;
    }

    public void setMaterialComponentName(String materialComponentName) {
        this.materialComponentName = materialComponentName;
    }

    public Boolean getFocus() {
        return focus;
    }

    public void setFocus(Boolean focus) {
        this.focus = focus;
    }

    public Boolean getDivineFocus() {
        return divineFocus;
    }

    public void setDivineFocus(Boolean divineFocus) {
        this.divineFocus = divineFocus;
    }

    public Boolean getGesture() {
        return gesture;
    }

    public void setGesture(Boolean gesture) {
        this.gesture = gesture;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Double getDurationInRounds() {
        return durationInRounds;
    }

    public void setDurationInRounds(Double durationInRounds) {
        this.durationInRounds = durationInRounds;
    }

    public Double getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Double durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getSpellResist() {
        return spellResist;
    }

    public void setSpellResist(Boolean spellResist) {
        this.spellResist = spellResist;
    }

    public Boolean getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(Boolean savingThrow) {
        this.savingThrow = savingThrow;
    }

    public String getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
}
