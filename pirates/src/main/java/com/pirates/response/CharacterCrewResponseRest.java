package com.pirates.response;

public class CharacterCrewResponseRest extends ResponseRest {
    private CharacterCrewResponse characterCrewResponse = new CharacterCrewResponse();

    public CharacterCrewResponse getCharacterCrewResponse() {
        return characterCrewResponse;
    }

    public void setCharacterCrewResponse(CharacterCrewResponse characterCrewResponse) {
        this.characterCrewResponse = characterCrewResponse;
    }
}
