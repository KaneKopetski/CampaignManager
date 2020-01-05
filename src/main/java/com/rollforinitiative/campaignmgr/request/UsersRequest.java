package com.rollforinitiative.campaignmgr.request;

import org.springframework.web.multipart.MultipartFile;

public class UsersRequest {
    private Long usersId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String aboutMe;
    private MultipartFile image;

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
