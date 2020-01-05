package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.exception.FileStorageException;
import com.rollforinitiative.campaignmgr.model.Users;
import com.rollforinitiative.campaignmgr.repository.UsersRepository;
import com.rollforinitiative.campaignmgr.request.LoginRequest;
import com.rollforinitiative.campaignmgr.request.RegisterRequest;
import com.rollforinitiative.campaignmgr.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;

    public void register(RegisterRequest registerRequest) {
        Users users = new Users();
        users.setUsername(registerRequest.getUsername());
        users.setPassword(encodePassword(registerRequest.getPassword()));
        users.setEmail(registerRequest.getEmail());
        users.setAboutMe(registerRequest.getAboutMe());
        users.setFirstName(registerRequest.getFirstName());
        users.setLastName(registerRequest.getLastName());
        try {
            users.setImage(registerRequest.getImage().getBytes());
        } catch (IOException e) {
            throw new FileStorageException("Could not store file.");
        }
        userRepository.save(users);
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String authenticationToken = jwtProvider.generateToken(authenticate);
        return new AuthenticationResponse(authenticationToken, loginRequest.getUsername());
    }

    public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }


}
