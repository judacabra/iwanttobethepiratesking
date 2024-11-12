package com.pirates.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pirates.model.dao.IUserDAO;
import com.pirates.response.UserResponse;
import com.pirates.response.UserResponseRest;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    private IUserDAO userDAO;

    @Override
    public ResponseEntity<UserResponseRest> getUsers() {
        UserResponseRest userResponseRest = new UserResponseRest();

        try {
            UserResponse userResponse = new UserResponse();
            
            userResponse.setGetListUser(userDAO.findAllWithProfileName());
            userResponseRest.setUserResponse(userResponse);
            userResponseRest.setMetaData("200", "Users Found");

            return ResponseEntity.ok().body(userResponseRest);
        } catch (Exception e) {
            userResponseRest.setMetaData("500", "Internal Server Error");
            
            return ResponseEntity.status(500).body(userResponseRest);
        }
    }

    @Override
    public ResponseEntity<UserResponseRest> getUserById(Integer id) {
        UserResponseRest userResponseRest = new UserResponseRest();

        try {
            UserResponse userResponse = new UserResponse();
            
            userResponse.setGetUser(userDAO.findById(id));
            userResponseRest.setUserResponse(userResponse);
            userResponseRest.setMetaData("200", "User Found");

            return ResponseEntity.ok().body(userResponseRest);
        } catch (Exception e) {
            userResponseRest.setMetaData("500", "Internal Server Error");
            
            return ResponseEntity.status(500).body(userResponseRest);
        }
    }
}
