package io.datajek.spring.basics.movie_recommender_system.impl;


import io.datajek.spring.basics.movie_recommender_system.filters.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class RecommenderImplementationV2 {

    private Filter filter;

    @Autowired
    @Qualifier("contentBasedFilter")
    public void setFilter(Filter filter) {
        this.filter = filter;
        System.out.println("Setter method invoked");
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of fileter in use" + filter + "\n");
        return filter.getRecommendations(movie);
    }
}


