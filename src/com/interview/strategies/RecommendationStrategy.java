package com.interview.strategies;

import com.interview.domain.User;
import com.interview.repositories.SongRepository;

public interface RecommendationStrategy {

    public void getRecommendation(User user, SongRepository songRepository);
}
