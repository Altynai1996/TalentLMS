package com.digitalnomads.api.controllers;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import com.digitalnomads.api.ApiRequest;
import com.digitalnomads.api.entities.User;
import com.digitalnomads.api.utils.JacksonUtils;

import java.util.HashMap;
import java.util.Map;

import static com.digitalnomads.api.application.TalentLMSBaseEndPoint.*;

@Slf4j
public class UserController extends ApiRequest {
    public UserController(String url) {
        super(url, API_KEY);
    }

    public Response getAllUsers() {
        return this.response = super.get(getEndPoint(API, V1, USERS));
    }

    public Response getUserByEmail(String email) {
        return this.response = super.getWithParams(getEndPoint(API, V1, USERS)
                , generateParams(EMAIL, email));
    }
    public Response getUserByUsername(String username){
        return this.response=super.getWithParams(getEndPoint(API, V1, USERS)
                , generateParams(USERNAME, username));
    }

    public boolean isUserOnline(String id) {
        return super.getWithParams(getEndPoint(API, V1, ONLINE),
                generateParams("user_id", id)).jsonPath().getBoolean("online");
    }

    public User createUser(User user) {
        String jsonUser = JacksonUtils.fromObjectToJson(user);
        return super.post(getEndPoint(API, V1, SIGN_UP), jsonUser).as(User.class);
    }

    public void deleteUser(String userID) {
        Map<String, String> params = new HashMap<>();
        params.put("deleted_by_user_id", "1");
        params.put("user_id", userID);
        super.postWithParams(getEndPoint(API, V1, DElETE_USER), params);
    }

    public boolean checkUserLimit() {
        User[] users = getAllUsers().as(User[].class);
        log.info("user length is: {}", users.length);
        if (users.length == 5) {
            return true;
        }
        return false;
    }
}

