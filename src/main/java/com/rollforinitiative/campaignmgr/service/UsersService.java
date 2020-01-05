package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.exception.UsersNotFoundException;
import com.rollforinitiative.campaignmgr.model.Users;
import com.rollforinitiative.campaignmgr.repository.UsersRepository;
import com.rollforinitiative.campaignmgr.request.UsersRequestLessPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Transactional
    public UsersRequestLessPassword getUsersByUserName(String username) {
        Users users = usersRepository.findByUsername(username).orElseThrow(() ->
                new UsersNotFoundException("For username: " + username));
        return mapUsersToUsersReqest(users);
    }

    public UsersRequestLessPassword mapUsersToUsersReqest(Users users) {
        UsersRequestLessPassword usersRequestLessPassword = new UsersRequestLessPassword();
        usersRequestLessPassword.setUsername(users.getUsername());
        usersRequestLessPassword.setFirstName(users.getFirstName());
        usersRequestLessPassword.setLastName(users.getLastName());
        usersRequestLessPassword.setEmail(users.getEmail());
        usersRequestLessPassword.setAboutMe(users.getAboutMe());
        usersRequestLessPassword.setProfilePicture(users.getProfilePicture());

        return usersRequestLessPassword;
    }

}
