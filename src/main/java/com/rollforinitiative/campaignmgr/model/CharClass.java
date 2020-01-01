package com.rollforinitiative.campaignmgr.model;

import javax.persistence.*;

@Entity
public class CharClass {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String className;
    @ManyToOne
    private Character character;

}
