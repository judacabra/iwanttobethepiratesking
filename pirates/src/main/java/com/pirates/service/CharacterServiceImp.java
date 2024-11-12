package com.pirates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pirates.model.Crew;
import com.pirates.model.PirateCharacter;
import com.pirates.model.dao.IPirateCharacterDAO;
import com.pirates.response.CharacterResponse;
import com.pirates.response.CharacterResponseRest;

@Service
public class CharacterServiceImp implements ICharacterService {
    @Autowired
    private IPirateCharacterDAO characterDAO;

    @Override
    public ResponseEntity<CharacterResponseRest> getCharacters() {
        CharacterResponseRest characterResponseRest = new CharacterResponseRest();

        try {
            CharacterResponse characterResponse = new CharacterResponse();
            
            characterResponse.setGetListCharacter(characterDAO.findAll());
            characterResponseRest.setCharacterResponse(characterResponse);
            characterResponseRest.setMetaData("200", "Characters Found");

            return ResponseEntity.ok().body(characterResponseRest);
        } catch (Exception e) {
            characterResponseRest.setMetaData("500", "Internal Server Error");
            
            return ResponseEntity.status(500).body(characterResponseRest);
        }
    }

    @Override
    public ResponseEntity<CharacterResponseRest> getCharactersByCrew(Integer id) {
        CharacterResponseRest characterResponseRest = new CharacterResponseRest();

        try {
            CharacterResponse characterResponse = new CharacterResponse();
            
            characterResponse.setGetListCharacter(characterDAO.findAllByCrew(id));
            characterResponseRest.setCharacterResponse(characterResponse);
            characterResponseRest.setMetaData("200", "Characters Found");

            return ResponseEntity.ok().body(characterResponseRest);
        } catch (Exception e) {
            characterResponseRest.setMetaData("500", "Internal Server Error");
            
            return ResponseEntity.status(500).body(characterResponseRest);
        }
    }

    @Transactional
    @Override
    public ResponseEntity<CharacterResponseRest> createCharacter(PirateCharacter character) {
        CharacterResponseRest characterResponseRest = new CharacterResponseRest();

        try {
            CharacterResponse characterResponse = new CharacterResponse();
            characterResponse.setGetCharacter(character);

            Crew crew = new Crew();
            crew.setId(character.getCrew().getId());
            character.setCrew(crew);

            characterDAO.insertCharacter(
                character.getAge(),
                character.getCreatedBy(),
                character.getCreatedDate(),
                character.getCrew().getId(),
                character.getJob(),
                character.getName()
            );

            characterResponseRest.setCharacterResponse(characterResponse);
            characterResponseRest.setMetaData("200", "Crew Created");

            return new ResponseEntity<>(characterResponseRest, HttpStatus.CREATED);

        } catch (Exception e) {
            characterResponseRest.setMetaData("500", "Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(characterResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
