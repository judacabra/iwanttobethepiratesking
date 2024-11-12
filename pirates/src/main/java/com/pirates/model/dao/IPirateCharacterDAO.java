package com.pirates.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pirates.model.PirateCharacter;

@Repository
public interface IPirateCharacterDAO extends CrudRepository<PirateCharacter, Long> {
    @Override
    List<PirateCharacter> findAll();

    @Modifying
    @Transactional
    @Query(value  = "INSERT INTO `character` (age, created_by, created_date, crew, job, name) " +
                    "VALUES (:age, :created_by, :created_date, :crew, :job, :name)", nativeQuery = true)
    int insertCharacter(String age, Integer created_by, Date created_date, Long crew, String job, String name); 

    @Query(value  = "SELECT c.id, c.name, c.age, c.crew, c.job, c.created_by, c.created_date " +
                "FROM `character_crew` cc " +
                "LEFT JOIN `character` c ON c.id = cc.id_character " +
                "LEFT JOIN crew cr ON cr.id = cc.id_crew " +
                "WHERE cc.id_crew = :id;", nativeQuery = true)
    List<PirateCharacter> findAllByCrew(Integer id);

    @Query(value  = "SELECT COUNT(*) FROM `character` WHERE crew = :id", nativeQuery = true)
    Integer hasAssociatedCharacters(Integer id);
}