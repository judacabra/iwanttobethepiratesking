package com.pirates.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pirates.model.Crew;
import com.pirates.model.PirateCharacter;
import com.pirates.model.User;
import com.pirates.response.CharacterResponseRest;
import com.pirates.response.CrewResponseRest;
import com.pirates.response.UserResponseRest;
import com.pirates.service.CharacterServiceImp;
import com.pirates.service.CrewServiceImp;
import com.pirates.service.UserServiceImp;

@RestController
@CrossOrigin(origins = "http://localhost") 
public class Api {

    @Autowired
    private CharacterServiceImp characterService;
    @GetMapping("/characters")
    public ResponseEntity<CharacterResponseRest> getCharacters() {
        return characterService.getCharacters();
    }

    @PostMapping("/characters/")
    public ResponseEntity<CharacterResponseRest> createCrew(@RequestBody PirateCharacter character) {
        return characterService.createCharacter(character);
    }

    @GetMapping("/character_crew/{id}")
    public ResponseEntity<CharacterResponseRest> getCharactersByCrew(@PathVariable Integer id) {
        return characterService.getCharactersByCrew(id);
    }

    @Autowired
    private CrewServiceImp crewService;
    @GetMapping("/crews")
    public ResponseEntity<CrewResponseRest> getCrews() {
        return crewService.getCrews();
    }

    @GetMapping("/crews/{id}")
    public ResponseEntity<CrewResponseRest> getCrewById(@PathVariable Integer id) {
        return crewService.getCrewById(id);
    }

    @PostMapping("/crews/")
    public ResponseEntity<CrewResponseRest> createCrew(@RequestBody Crew crew) {
        return crewService.createCrew(crew);
    }

    @PutMapping("/crews/")
    public ResponseEntity<CrewResponseRest> updateCrew(@RequestBody Crew crew) {
        return crewService.updateCrew(crew);
    }

    @DeleteMapping("/crews/{id}")
    public ResponseEntity<CrewResponseRest> deleteCrew(@PathVariable Integer id) {
        return crewService.deleteCrew(id);
    }

    @Autowired
    private UserServiceImp userService;
    @GetMapping("/users")
    public ResponseEntity<UserResponseRest> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseRest> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/login/")
    public boolean login(@RequestBody User user) {
        Map<String, String> validCredentials = new HashMap<>();
        validCredentials.put("Administrator", "1234");
        validCredentials.put("UserClient", "5678");

        String username = user.getUsername();
        String password = user.getPassword();

        return password.equals(validCredentials.get(username));
    }
}
