package com.pirates.response;

import java.util.List;

import com.pirates.model.CharacterCrew;

public class CharacterCrewResponse {
    private List<CharacterCrew> getListCharacterCrew;

    public List<CharacterCrew> getGetListCharacterCrew() {
        return getListCharacterCrew;
    }

    public void setGetListCharacterCrew(List<CharacterCrew> getListCharacterCrew) {
        this.getListCharacterCrew = getListCharacterCrew;
    }
}
