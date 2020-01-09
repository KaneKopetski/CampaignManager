package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.model.Image;
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

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private ImageService imageService;

    public void register(RegisterRequest registerRequest) {
        Users newUser = new Users();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(encodePassword(registerRequest.getPassword()));
        newUser.setEmail(registerRequest.getEmail());
        newUser.setAboutMe(registerRequest.getAboutMe());
        newUser.setFirstName(registerRequest.getFirstName());
        newUser.setLastName(registerRequest.getLastName());

        Image profilePicture = imageService.storeImage(registerRequest.getImage());

        newUser.setProfilePicture(profilePicture);

        usersRepository.save(newUser);
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
