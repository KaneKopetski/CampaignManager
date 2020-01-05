package com.rollforinitiative.campaignmgr.controller;

import com.rollforinitiative.campaignmgr.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

}
