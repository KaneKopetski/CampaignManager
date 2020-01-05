package com.rollforinitiative.campaignmgr.controller;

import com.rollforinitiative.campaignmgr.request.UsersLessPasswordRequest;
import com.rollforinitiative.campaignmgr.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/get")
    public UsersLessPasswordRequest findUserByUserName(String username) {
        return usersService.getUsersByUserName(username);
    }
}
