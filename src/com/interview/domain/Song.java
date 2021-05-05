package com.interview.domain;

import com.interview.enums.Genre;

import java.util.HashMap;
import java.util.Map;

public class Song {

    String name;
    Map<Genre, Integer> genreScores;

    public Song(String name){
        this.name = name;
        this.genreScores = new HashMap<>();
    }

    public Song(String name, Map<Genre, Integer> genreScores){
        this.name = name;
        this.genreScores = genreScores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Genre, Integer> getGenreScores() {
        return genreScores;
    }

    public void setGenreScores(Map<Genre, Integer> genreScores) {
        this.genreScores = genreScores;
    }
}
