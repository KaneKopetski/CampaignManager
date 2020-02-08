package com.rollforinitiative.campaignmgr.service;

import com.rollforinitiative.campaignmgr.exception.CharacterNotFoundException;
import com.rollforinitiative.campaignmgr.exception.UsersNotFoundException;
import com.rollforinitiative.campaignmgr.model.*;
import com.rollforinitiative.campaignmgr.repository.CharacterRepository;
import com.rollforinitiative.campaignmgr.repository.UsersRepository;
import com.rollforinitiative.campaignmgr.request.CampaignRequest;
import com.rollforinitiative.campaignmgr.request.CharacterRequest;
import com.rollforinitiative.campaignmgr.response.CampaignResponse;
import com.rollforinitiative.campaignmgr.response.CharacterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private AuthService authService;

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private PartyService partyService;

    @Autowired
    private UsersRepository usersRepository;

    public List<CharacterResponse> getCharactersByCampaign(Long campaignId) {
        List<PlayerCharacter> characters = characterRepository.findByCampaign_campaignId(campaignId);
        return characters.stream().map(this::mapFromCharacterToResponse).collect(toList());
    }

    public List<CharacterResponse> getCharactersByParty(Long partyId) {
        List<PlayerCharacter> characters = characterRepository.findByParty_partyId(partyId);
        return characters.stream().map(this::mapFromCharacterToResponse).collect(toList());
    }

    //TODO Take a look at username vs. userId. Need to determine which should be unique identifier
    public List<CharacterResponse> getCharactersByUsername(String username) {
        Long id = usersRepository.findByUsername(username).orElseThrow(() ->
                new UsersNotFoundException("For username: " + username)).getUsersId();
        List<PlayerCharacter> characters = characterRepository.findByOwner_usersId(id);
        return characters.stream().map(this::mapFromCharacterToResponse).collect(toList());
    }

    public CharacterResponse getCharacterResponseById(Long characterId) {
        PlayerCharacter character = characterRepository.findById(characterId).orElseThrow(() ->
                new CharacterNotFoundException("For character ID: " + characterId));
        return mapFromCharacterToResponse(character);
    }

    private CharacterResponse mapFromCharacterToResponse(PlayerCharacter playerCharacter) {
        CharacterResponse characterResponse = new CharacterResponse();
        characterResponse.setCharacterId(playerCharacter.getCharacterId());
        characterResponse.setBackstory(playerCharacter.getBackstory());
        characterResponse.setAge(playerCharacter.getAge());
        characterResponse.setName(playerCharacter.getName());
        characterResponse.setCharLevel(playerCharacter.getCharLevel());
        characterResponse.setStrength(playerCharacter.getStrength());
        characterResponse.setConstitution(playerCharacter.getConstitution());
        characterResponse.setDexterity(playerCharacter.getDexterity());
        characterResponse.setWisdom(playerCharacter.getWisdom());
        characterResponse.setIntelligence(playerCharacter.getIntelligence());
        characterResponse.setCharisma(playerCharacter.getCharisma());
        characterResponse.setAttack(playerCharacter.getAttack());
        characterResponse.setArmorClass(playerCharacter.getArmorClass());
        characterResponse.setSpeed(playerCharacter.getSpeed());
        characterResponse.setParty(playerCharacter.getParty());
        characterResponse.setOwner(playerCharacter.getOwner());
        characterResponse.setRace(playerCharacter.getRace());
        characterResponse.setClasses(playerCharacter.getClasses());
        characterResponse.setCampaign(playerCharacter.getCampaign());
        characterResponse.setPortrait(playerCharacter.getPortrait());
        characterResponse.setMapIcon(playerCharacter.getMapIcon());
        return characterResponse;
    }

    private PlayerCharacter mapFromRequestToCharacter(CharacterRequest characterRequest) {
        PlayerCharacter playerCharacter = new PlayerCharacter();
        playerCharacter.setBackstory(characterRequest.getBackstory());
        playerCharacter.setAge(characterRequest.getAge());
        playerCharacter.setName(characterRequest.getName());
        playerCharacter.setCharLevel(characterRequest.getCharLevel());
        playerCharacter.setStrength(characterRequest.getStrength());
        playerCharacter.setConstitution(characterRequest.getConstitution());
        playerCharacter.setDexterity(characterRequest.getDexterity());
        playerCharacter.setWisdom(characterRequest.getWisdom());
        playerCharacter.setIntelligence(characterRequest.getIntelligence());
        playerCharacter.setCharisma(characterRequest.getCharisma());
        playerCharacter.setAttack(characterRequest.getAttack());
        playerCharacter.setArmorClass(characterRequest.getArmorClass());
        playerCharacter.setSpeed(characterRequest.getSpeed());
        playerCharacter.setClasses(characterRequest.getClasses());
        playerCharacter.setRace(characterRequest.getRace());

        playerCharacter.setParty(partyService.getPartyEntityById(characterRequest.getParty().getPartyId()));
        playerCharacter.setCampaign(campaignService.getCampaignEntityById(characterRequest.getCampaign().getCampaignId()));

        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User not found."));
        Users owner = usersRepository.findByUsername(loggedInUser.getUsername()).get();
        playerCharacter.setOwner(owner);

        Image portrait = imageService.storeImage(characterRequest.getPortrait());
        Image mapIcon = imageService.storeImage(characterRequest.getMapIcon());

        playerCharacter.setPortrait(portrait);
        playerCharacter.setMapIcon(mapIcon);

        return playerCharacter;
    }


}
