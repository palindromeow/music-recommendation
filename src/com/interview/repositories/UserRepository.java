package com.interview.repositories;

import com.interview.domain.User;
import com.interview.exceptions.UserAlreadyExistsException;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    Map<String, User> users;

    public UserRepository(){
        users = new HashMap<>();
    }

    public void add(User newUser) throws UserAlreadyExistsException{
        if(users.containsKey(newUser.getName())){
            throw new UserAlreadyExistsException(
                    String.format("User %s already exists!", newUser.getName()));
        }

        users.put(newUser.getName(), newUser);
    }
}
