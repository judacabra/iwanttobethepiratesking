package com.pirates.response;

import java.util.List;

import com.pirates.model.Crew;

public class CrewResponse {
    private List<Crew> getListCrew;
    private Crew crew;

    public List<Crew> getGetListCrew() {
        return getListCrew;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setGetListCrew(List<Crew> getListCrew) {
        this.getListCrew = getListCrew;
    }

    public void setGetCrew(Crew crew) {
        this.crew = crew;
    }

}
