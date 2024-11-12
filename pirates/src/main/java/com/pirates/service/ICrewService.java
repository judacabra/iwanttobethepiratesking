package com.pirates.service;

import org.springframework.http.ResponseEntity;

import com.pirates.model.Crew;
import com.pirates.response.CrewResponseRest;

public interface ICrewService {
    public ResponseEntity<CrewResponseRest> getCrews();
    public ResponseEntity<CrewResponseRest> getCrewById(Integer id);
    public ResponseEntity<CrewResponseRest> createCrew(Crew crew);
    public ResponseEntity<CrewResponseRest> updateCrew(Crew crew);
    public ResponseEntity<CrewResponseRest> deleteCrew(Integer id);
}
