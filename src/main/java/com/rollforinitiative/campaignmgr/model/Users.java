package com.rollforinitiative.campaignmgr.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long usersId;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String aboutMe;
    @ManyToOne
    private Campaign campaign;
    @ManyToOne
    private Character character;

}
