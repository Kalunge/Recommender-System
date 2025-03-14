package io.datajek.spring.basics.movie_recommender_system.impl;

import io.datajek.spring.basics.movie_recommender_system.filters.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class RecommenderImplementation {

    @Qualifier("collaborativeBasedFilter")
    @Autowired
    private Filter collaborativeBased;

    @Qualifier("contentBasedFilter")
    @Autowired
    private Filter contentBased;

    public RecommenderImplementation(@Qualifier("collaborativeBasedFilter") Filter collaborativeBased, @Qualifier("contentBasedFilter") Filter contentBased) {
        super();
        this.collaborativeBased = collaborativeBased;
        this.contentBased = contentBased;
    }

    public String[] recommendMovies(String movie) {
        System.out.println("Name of fileter in use" + contentBased + "\n");
        return contentBased.getRecommendations("Finding Dory");
    }
}
