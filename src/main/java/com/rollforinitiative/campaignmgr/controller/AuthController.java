package com.rollforinitiative.campaignmgr.controller;

import com.rollforinitiative.campaignmgr.request.LoginRequest;
import com.rollforinitiative.campaignmgr.request.RegisterRequest;
import com.rollforinitiative.campaignmgr.service.AuthService;
import com.rollforinitiative.campaignmgr.service.AuthenticationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        String username = registerRequest.getUsername();
        LOGGER.info("Signup post request received. Username: {}", username);
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }
}