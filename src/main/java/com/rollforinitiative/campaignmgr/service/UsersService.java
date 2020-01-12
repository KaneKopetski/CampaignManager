package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.exception.UsersNotFoundException;
import com.rollforinitiative.campaignmgr.model.Users;
import com.rollforinitiative.campaignmgr.repository.UsersRepository;
import com.rollforinitiative.campaignmgr.response.UsersLessPasswordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public UsersLessPasswordResponse getUsersByUserName(String username) {
        Users users = usersRepository.findByUsername(username).orElseThrow(() ->
                new UsersNotFoundException("For username: " + username));
        return mapUsersToUsersRequest(users);
    }

    public UsersLessPasswordResponse mapUsersToUsersRequest(Users users) {
        UsersLessPasswordResponse usersLessPasswordResponse = new UsersLessPasswordResponse();
        usersLessPasswordResponse.setUsername(users.getUsername());
        usersLessPasswordResponse.setFirstName(users.getFirstName());
        usersLessPasswordResponse.setLastName(users.getLastName());
        usersLessPasswordResponse.setEmail(users.getEmail());
        usersLessPasswordResponse.setAboutMe(users.getAboutMe());
        usersLessPasswordResponse.setProfilePicture(users.getProfilePicture());

        return usersLessPasswordResponse;
    }

}
