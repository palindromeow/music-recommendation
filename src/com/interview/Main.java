package com.interview;

import com.interview.domain.MusicSystem;
import com.interview.domain.Song;
import com.interview.domain.User;
import com.interview.enums.Genre;
import com.interview.strategies.AverageStrategy;
import com.interview.strategies.RecommendationStrategy;

public class Main {

    public static void main(String[] args) {

        // singleton
        MusicSystem musicSystem = MusicSystem.getInstance();

        Song fixYou = new Song("Fix You");
        fixYou.getGenreScores().put(Genre.ALT, 5);
        fixYou.getGenreScores().put(Genre.POP, 5);

        Song gravity = new Song("Gravity");
        gravity.getGenreScores().put(Genre.ROCK, 3);
        gravity.getGenreScores().put(Genre.BLUES, 7);

        Song rickRoll = new Song("Never Gonna Give You Up");
        rickRoll.getGenreScores().put(Genre.ALT, 10);
        rickRoll.getGenreScores().put(Genre.POP, 10);
        rickRoll.getGenreScores().put(Genre.ROCK, 10);
        rickRoll.getGenreScores().put(Genre.BLUES, 10);

        musicSystem.addSong(fixYou);
        musicSystem.addSong(gravity);
        musicSystem.addSong(rickRoll);

        User user = new User("James");
        musicSystem.addUser(user);

        /* TODO - make User methods called
            createPlaylist(), addSong(Song song), printPlayList()
            instead of this
         */
        user.getPlaylist().add(fixYou);
        user.getPlaylist().add(gravity);
        for(Song song : user.getPlaylist()){
            System.out.println(String.format("User: %s listens to song: %s",
                    user.getName(), song.getName()));
        }

        // composition
        RecommendationStrategy strategy = new AverageStrategy();
        musicSystem.setStrategy(strategy);

        // should show rickroll as that is a suitable song
        // according to provided strategy
        musicSystem.getRecommendation(user);

    }
}
