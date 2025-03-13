package io.datajek.spring.basics.movie_recommender_system;

import io.datajek.spring.basics.movie_recommender_system.filters.*;
import io.datajek.spring.basics.movie_recommender_system.impl.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class MovieRecommenderSystemApplication {
    public static void main(String[] args) {
        RecommenderImplementation recommender = new RecommenderImplementation(new CollaborativeBasedFilter());
        String[] result = recommender.recommendMovies("Finding Dorry");
        System.out.println(Arrays.toString(result));
    }
}
