package com.interview.repositories;

import com.interview.domain.Song;
import com.interview.exceptions.SongAlreadyExistsException;


import java.util.HashMap;
import java.util.Map;

public class SongRepository {

    Map<String, Song> songs;

    public SongRepository(){
        songs = new HashMap<>();
    }

    public void add(Song newSong) throws SongAlreadyExistsException {
        if(songs.containsKey(newSong.getName())){
            throw new SongAlreadyExistsException(
                    String.format("Song %s already exists!", newSong.getName()));
        }

        songs.put(newSong.getName(), newSong);
    }

    public Map<String, Song> getSongs() {
        return songs;
    }

    public void setSongs(Map<String, Song> songs) {
        this.songs = songs;
    }
}
