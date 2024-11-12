package com.pirates.service;

import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pirates.model.Crew;
import com.pirates.model.dao.ICrewDAO;
import com.pirates.model.dao.IPirateCharacterDAO;
import com.pirates.response.CrewResponse;
import com.pirates.response.CrewResponseRest;

@Service
public class CrewServiceImp implements ICrewService {
    @Autowired
    private ICrewDAO crewDAO;
    
    @Autowired
    private IPirateCharacterDAO characterDAO;

    @Override
    public ResponseEntity<CrewResponseRest> getCrews() {
        CrewResponseRest crewResponseRest = new CrewResponseRest();

        try {
            CrewResponse crewResponse = new CrewResponse();
            
            crewResponse.setGetListCrew(crewDAO.findAll());
            crewResponseRest.setCrewResponse(crewResponse);
            crewResponseRest.setMetaData("200", "Crews Found");

            return ResponseEntity.ok().body(crewResponseRest);
        } catch (Exception e) {
            crewResponseRest.setMetaData("500", "Internal Server Error");
            
            return ResponseEntity.status(500).body(crewResponseRest);
        }
    }

    @Override
    public ResponseEntity<CrewResponseRest> getCrewById(Integer id) {
        CrewResponseRest crewResponseRest = new CrewResponseRest();

        try {
            CrewResponse crewResponse = new CrewResponse();
            
            crewResponse.setGetCrew(crewDAO.findById(id));
            crewResponseRest.setCrewResponse(crewResponse);
            crewResponseRest.setMetaData("200", "Crews Found");

            return ResponseEntity.ok().body(crewResponseRest);
        } catch (Exception e) {
            crewResponseRest.setMetaData("500", "Internal Server Error");
            
            return ResponseEntity.status(500).body(crewResponseRest);
        }
    }

    @Transactional
    @Override
    public ResponseEntity<CrewResponseRest> createCrew(Crew crew) {
        CrewResponseRest crewResponseRest = new CrewResponseRest();

        try {
            CrewResponse crewResponse = new CrewResponse();
            crewResponse.setGetCrew(crew);  
            
            crewDAO.insertCrew(
                crew.getCreatedBy(),
                crew.getCreatedDate(),
                crew.getDescription(),
                crew.getName(),
                crew.getNumber(),
                crew.getRomanName(),
                crew.getStatus(),
                crew.getFlag(),
                crew.getShip()
            );

            crewResponseRest.setCrewResponse(crewResponse);
            crewResponseRest.setMetaData("200", "Crew Created");  
            
            return new ResponseEntity<>(crewResponseRest, HttpStatus.CREATED);

        } catch (Exception e) {
            crewResponseRest.setMetaData("500", "Internal Server Error: " + e.getMessage());
            
            return new ResponseEntity<>(crewResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @Override
    public ResponseEntity<CrewResponseRest> updateCrew(Crew crew) {
        CrewResponseRest crewResponseRest = new CrewResponseRest();

        try {
            Optional<Crew> existingCrew = crewDAO.findById(crew.getId());
            if (existingCrew.isEmpty()) {
                crewResponseRest.setMetaData("404", "Crew not found");
                return new ResponseEntity<>(crewResponseRest, HttpStatus.NOT_FOUND);
            }

            CrewResponse crewResponse = new CrewResponse();
            crewResponse.setGetCrew(crew);

            crewDAO.updateCrew(
                crew.getId(),
                crew.getDescription(),
                crew.getName(),
                crew.getNumber(),
                crew.getRomanName(),
                crew.getStatus(),
                crew.getFlag(),
                crew.getShip()
            );

            crewResponseRest.setCrewResponse(crewResponse);
            crewResponseRest.setMetaData("200", "Crew Updated");

            return new ResponseEntity<>(crewResponseRest, HttpStatus.OK);
        } catch (Exception e) {
            crewResponseRest.setMetaData("500", "Internal Server Error: " + e.getMessage());
            return new ResponseEntity<>(crewResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @Override
    public ResponseEntity<CrewResponseRest> deleteCrew(Integer id) {
        CrewResponseRest crewResponseRest = new CrewResponseRest();
        try {
            CrewResponse crewResponse = new CrewResponse();

            Integer hasCharacters = characterDAO.hasAssociatedCharacters(id);

            if (hasCharacters > 0) {
                crewResponseRest.setMetaData("400", "Cannot delete Crew because there are Characters associated with it.");
                return new ResponseEntity<>(crewResponseRest, HttpStatus.BAD_REQUEST);
            }

            // Intentar eliminar la tripulación
            crewDAO.deleteCrew(id);

            crewResponseRest.setCrewResponse(crewResponse);
            crewResponseRest.setMetaData("200", "Crew Deleted");

            return new ResponseEntity<>(crewResponseRest, HttpStatus.OK);

        } catch (DataAccessException dae) {
            crewResponseRest.setMetaData("500", "Database access error: " + dae.getMessage());
            return new ResponseEntity<>(crewResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (ConstraintViolationException cve) {
            crewResponseRest.setMetaData("500", "Constraint violation: " + cve.getMessage());
            return new ResponseEntity<>(crewResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HibernateException he) {
            crewResponseRest.setMetaData("500", "Hibernate error: " + he.getMessage());
            return new ResponseEntity<>(crewResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            crewResponseRest.setMetaData("500", "Unexpected error: " + e.getMessage());
            return new ResponseEntity<>(crewResponseRest, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
