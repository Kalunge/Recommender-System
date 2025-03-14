package io.datajek.spring.basics.movie_recommender_system.filters;

import org.springframework.stereotype.*;


public interface Filter {
    String[] getRecommendations(String move);
}
