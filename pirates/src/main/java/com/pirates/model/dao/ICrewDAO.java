package com.pirates.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pirates.model.Crew;

@Repository
public interface ICrewDAO extends CrudRepository<Crew, Long> {
    @Override
    List<Crew> findAll();

    @Query(value  = "SELECT * FROM crew WHERE id = :id", nativeQuery = true)
    Crew findById(Integer id);

    @Modifying
    @Transactional
    @Query(value  = "INSERT INTO crew (created_by, created_date, description, name, number, roman_name, status, flag, ship) " +
                    "VALUES (:created_by, :created_date, :description, :name, :number, :roman_name, :status, :flag, :ship)", 
                    nativeQuery = true)
    int insertCrew(Integer created_by, Date created_date, String description, String name, Integer number, 
                    String roman_name, String status, String flag, String ship); 

    @Modifying
    @Transactional
    @Query(value  = "UPDATE crew " +
                    "SET description = :description, name = :name, number = :number, roman_name = :roman_name, " +
                    "status = :status, flag = :flag, ship = :ship " +
                    "WHERE id = :id", 
                    nativeQuery = true)
    int updateCrew(Long id, String description, String name, Integer number, String roman_name, String status, String flag, String ship);
    
    @Modifying
    @Transactional
    @Query(value  = "DELETE FROM crew WHERE id = :id", nativeQuery = true)
    void deleteCrew(Integer id);
}