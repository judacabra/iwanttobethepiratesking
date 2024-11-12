package com.pirates.response;

public class CrewResponseRest extends ResponseRest {
    private CrewResponse crewResponse = new CrewResponse();

    public CrewResponse getCrewResponse() {
        return crewResponse;
    }

    public void setCrewResponse(CrewResponse crewResponse) {
        this.crewResponse = crewResponse;
    }
}
