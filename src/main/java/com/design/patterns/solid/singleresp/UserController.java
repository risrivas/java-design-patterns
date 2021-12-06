package com.design.patterns.solid.singleresp;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

//Handles incoming JSON requests that work on User resource/entity
public class UserController {
    private final UserValidator validator = new UserValidator();
    private final UserPersistenceService persistenceService = new UserPersistenceService();

    //Create a new user
    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);

        boolean isValid = validator.validateUser(user);
        if (!isValid) {
            return "ERROR";
        }

        persistenceService.persist(user);

        return "SUCCESS";
    }


}