package com.pirates.service;

import org.springframework.http.ResponseEntity;

import com.pirates.response.UserResponseRest;

public interface IUserService {
    public ResponseEntity<UserResponseRest> getUsers();
    public ResponseEntity<UserResponseRest> getUserById(Integer id);
}
