package com.interview.domain;

import com.interview.exceptions.SongAlreadyExistsException;
import com.interview.exceptions.UserAlreadyExistsException;
import com.interview.repositories.SongRepository;
import com.interview.repositories.UserRepository;
import com.interview.strategies.RecommendationStrategy;


public class MusicSystem {

    private static MusicSystem INSTANCE;

    SongRepository songRepository;
    UserRepository userRepository;

    RecommendationStrategy strategy;

    public static synchronized MusicSystem getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MusicSystem();
        }
        return INSTANCE;
    }

    private MusicSystem(){

        this.songRepository = new SongRepository();
        this.userRepository = new UserRepository();
    }

    public void getRecommendation(User user){

        strategy.getRecommendation(user, songRepository);
    }

    public boolean addUser(User user){

        try {
            userRepository.add(user);
        }
        catch (UserAlreadyExistsException exception){
            System.out.println(exception.getMessage());
            return false;
        }

        return true;
    }

    public boolean addSong(Song song){

        try {
            songRepository.add(song);
        }
        catch (SongAlreadyExistsException exception){
            System.out.println(exception.getMessage());
            return false;
        }

        return true;
    }

    public RecommendationStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

}
