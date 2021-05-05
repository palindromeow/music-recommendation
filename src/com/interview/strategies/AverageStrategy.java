package com.interview.strategies;

import com.interview.domain.Song;
import com.interview.domain.User;
import com.interview.enums.Genre;
import com.interview.repositories.SongRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Prints all new songs for which all genres
 * have scores over the current average genre score
 */
public class AverageStrategy implements RecommendationStrategy{
    @Override
    public void getRecommendation(User user, SongRepository songRepository) {

        Map<Genre,Double> averageGenreScore = new HashMap<>();
        for(Song song : user.getPlaylist()){
            for(Genre genre : song.getGenreScores().keySet()){

                double oldScore = averageGenreScore.getOrDefault(genre, 0.0);
                double increment = song.getGenreScores().get(genre) / (1.0 * song.getGenreScores().size());
                averageGenreScore.put(genre, oldScore+increment);
            }
        }

        for(Song song : songRepository.getSongs().values()){
            if(!user.getPlaylist().contains(song)){
                boolean isSuitable = true;
                for(Genre genre : averageGenreScore.keySet()){
                    if(song.getGenreScores().get(genre) < averageGenreScore.get(genre)){
                        isSuitable = false;
                        break;
                    }
                }
                if(isSuitable)
                    System.out.println(String.format("Recommendation for user: %s, song: %s", user.getName(), song.getName()));
            }
        }

    }
}
