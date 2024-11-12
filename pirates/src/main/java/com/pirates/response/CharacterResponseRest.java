package com.pirates.response;

public class CharacterResponseRest extends ResponseRest {
    private CharacterResponse characterResponse = new CharacterResponse();

    public CharacterResponse getCharacterResponse() {
        return characterResponse;
    }

    public void setCharacterResponse(CharacterResponse characterResponse) {
        this.characterResponse = characterResponse;
    }
}
