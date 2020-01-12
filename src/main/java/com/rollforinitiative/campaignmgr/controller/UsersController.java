package com.rollforinitiative.campaignmgr.controller;

import com.rollforinitiative.campaignmgr.response.UsersLessPasswordResponse;
import com.rollforinitiative.campaignmgr.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);


    @GetMapping("/get/{username}")
    public ResponseEntity<UsersLessPasswordResponse> findUserByUserName(@PathVariable String username) {
        LOGGER.info("User profile requested for username: " + username);
        return new ResponseEntity<>(usersService.getUsersByUserName(username), HttpStatus.OK);
    }
}
