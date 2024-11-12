package com.pirates.response;

import java.util.List;

import com.pirates.model.User;

public class UserResponse {
    private List<User> getListUser;
    private User getUser;

    public List<User> getGetListUser() {
        return getListUser;
    }

    public User getGetUser() {
        return getUser;
    }

    public void setGetListUser(List<User> getListUser) {
        this.getListUser = getListUser;
    }

    public void setGetUser(User getUser) {
        this.getUser = getUser;
    }
}
