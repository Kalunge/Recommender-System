package io.datajek.spring.basics.movie_recommender_system.impl;

import io.datajek.spring.basics.movie_recommender_system.filters.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {


    @Autowired
    @Qualifier("CF")
    private Filter collaborativeBasedFilter;


    public String[] recommendMovies(String movie) {
        System.out.println("Name of fileter in use" + collaborativeBasedFilter + "\n");
        return collaborativeBasedFilter.getRecommendations("Finding Dory");
    }
}
