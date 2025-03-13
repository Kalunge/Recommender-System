package io.datajek.spring.basics.movie_recommender_system.impl;

import io.datajek.spring.basics.movie_recommender_system.filters.*;

public class RecommenderImplementation {
    private final Filter filter;

    public RecommenderImplementation(Filter filter) {
        super();
        this.filter = filter;
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of fileter in use" + filter + "\n");
        return filter.getRecommendations("Finding Dory");
    }
}
