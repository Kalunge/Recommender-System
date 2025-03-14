package io.datajek.spring.basics.movie_recommender_system;

import io.datajek.spring.basics.movie_recommender_system.filters.*;
import io.datajek.spring.basics.movie_recommender_system.impl.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;

import java.util.*;

@SpringBootApplication
public class MovieRecommenderSystemApplication {
    public static void main(String[] args) {
        // application context manages the beans and dependencies
        ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);

        // we can use appcontext to find which filter is being used
        RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);

        // call method to get recommendations
        String[] result = recommender.recommendMovies("Finding Dorry");

        System.out.println(Arrays.toString(result));

    }
}
