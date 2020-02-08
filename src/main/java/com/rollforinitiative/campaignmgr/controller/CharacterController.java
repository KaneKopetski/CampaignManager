package com.rollforinitiative.campaignmgr.controller;

import com.rollforinitiative.campaignmgr.exception.CampaignNotFoundException;
import com.rollforinitiative.campaignmgr.request.CampaignRequest;
import com.rollforinitiative.campaignmgr.response.CampaignResponse;
import com.rollforinitiative.campaignmgr.response.CharacterResponse;
import com.rollforinitiative.campaignmgr.service.CharacterService;
import com.rollforinitiative.campaignmgr.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private UsersService usersService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CampaignController.class);

    @Valid
    @GetMapping("/campaign/{campaignId}/get/characters")
    public ResponseEntity<List<CharacterResponse>> getAllCharactersByCampaign(@PathVariable Long campaignId) {
        List<CharacterResponse> allCharacters = characterService.getCharactersByCampaign(campaignId);
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }

    @Valid
    @GetMapping("/party/{partyId}/get/characters/all")
    public ResponseEntity<List<CharacterResponse>> getAllCharactersByParty(@PathVariable Long partyId) {
        List<CharacterResponse> allCharacters = characterService.getCharactersByParty(partyId);
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }

    @Valid
    @GetMapping("/users/{username}/get/characters/all")
    public ResponseEntity<List<CharacterResponse>> getAllCharactersByOwner(@PathVariable String username) {
        List<CharacterResponse> allCharacters = characterService.getCharactersByUsername(username);
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }

    @GetMapping("/get/{characterId}")
    public ResponseEntity<CharacterResponse> getCharacterById(@PathVariable Long characterId) {
        return new ResponseEntity<>(characterService.getCharacterResponseById(characterId), HttpStatus.OK);
    }



}
