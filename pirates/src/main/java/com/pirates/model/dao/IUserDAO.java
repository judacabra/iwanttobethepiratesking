package com.pirates.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pirates.model.User;

@Repository
public interface IUserDAO extends CrudRepository<User, Long> {
    @Query(value  = "SELECT u.id, u.name, u.username, u.password, u.profile, p.name AS profileName " +
                    "FROM user u " +
                    "LEFT JOIN profile p ON u.profile = p.id", nativeQuery = true)
    List<User> findAllWithProfileName();

    @Query(value  = "SELECT * FROM user WHERE id = :id", nativeQuery = true)
    User findById(Integer id);
}