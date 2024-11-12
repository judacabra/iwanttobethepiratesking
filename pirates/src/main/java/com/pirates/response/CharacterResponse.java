package com.pirates.response;

import java.util.List;

import com.pirates.model.PirateCharacter;

public class CharacterResponse {
    private List<PirateCharacter> getListCharacter;
    private PirateCharacter getCharacter;

    public List<PirateCharacter> getGetListCharacter() {
        return getListCharacter;
    }

    public PirateCharacter getGetCharacter() {
        return getCharacter;
    }

    public void setGetListCharacter(List<PirateCharacter> getListCharacter) {
        this.getListCharacter = getListCharacter;
    }

    public void setGetCharacter(PirateCharacter getCharacter) {
        this.getCharacter = getCharacter;
    }
}
