package com.interview;

import com.interview.domain.User;
import com.interview.repositories.UserRepository;

// use -ea flag for assert
public class Test {

    public static void testUserAlreadyExists(){

        UserRepository userRepository = new UserRepository();
        User user1 = new User("John");
        userRepository.add(user1);

        User user2 = new User("John");
        try {
            userRepository.add(user2);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        User user3 = new User("James");
        userRepository.add(user3);

        assert userRepository.users.size() == 2 : "Should be 2 users";
    }


    public static void main(String[] args) {

        testUserAlreadyExists();
    }
}
