package com.pirates.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="character_crew")
public class CharacterCrew implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="id_character")
    private Integer idCharacter;

    @Column(name="id_crew")
    private Integer idCrew;

    public CharacterCrew() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(Integer idCharacter) {
        this.idCharacter = idCharacter;
    }

    public Integer getIdCrew() {
        return idCrew;
    }

    public void setIdCrew(Integer idCrew) {
        this.idCrew = idCrew;
    }
}
