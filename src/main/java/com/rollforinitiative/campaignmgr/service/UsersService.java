package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.exception.UsersNotFoundException;
import com.rollforinitiative.campaignmgr.model.Users;
import com.rollforinitiative.campaignmgr.repository.UsersRepository;
import com.rollforinitiative.campaignmgr.request.UsersLessPasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public UsersLessPasswordRequest getUsersByUserName(String username) {
        Users users = usersRepository.findByUsername(username).orElseThrow(() ->
                new UsersNotFoundException("For username: " + username));
        return mapUsersToUsersReqest(users);
    }

    public UsersLessPasswordRequest mapUsersToUsersReqest(Users users) {
        UsersLessPasswordRequest usersLessPasswordRequest = new UsersLessPasswordRequest();
        usersLessPasswordRequest.setUsername(users.getUsername());
        usersLessPasswordRequest.setFirstName(users.getFirstName());
        usersLessPasswordRequest.setLastName(users.getLastName());
        usersLessPasswordRequest.setEmail(users.getEmail());
        usersLessPasswordRequest.setAboutMe(users.getAboutMe());
        usersLessPasswordRequest.setProfilePicture(users.getProfilePicture());

        return usersLessPasswordRequest;
    }

}
