package com.pirates.service;

import org.springframework.http.ResponseEntity;

import com.pirates.model.PirateCharacter;
import com.pirates.response.CharacterResponseRest;

public interface ICharacterService {
    public ResponseEntity<CharacterResponseRest> getCharacters();
    public ResponseEntity<CharacterResponseRest> getCharactersByCrew(Integer id);
    public ResponseEntity<CharacterResponseRest> createCharacter(PirateCharacter character);
}
