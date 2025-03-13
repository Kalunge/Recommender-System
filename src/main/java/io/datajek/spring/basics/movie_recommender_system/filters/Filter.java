package io.datajek.spring.basics.movie_recommender_system.filters;

public interface Filter {
    String[] getRecommendations(String move);
}
