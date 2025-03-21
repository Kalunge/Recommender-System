package io.datajek.spring.basics.movie_recommender_system;

import io.datajek.spring.basics.movie_recommender_system.filters.*;
import io.datajek.spring.basics.movie_recommender_system.impl.*;
import io.datajek.spring.basics.movie_recommender_system.movies.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;

import java.util.*;

@SpringBootApplication
public class MovieRecommenderSystemApplication {
    public static void main(String[] args) {
        // application context manages the beans and dependencies
        ApplicationContext appContext = SpringApplication.run(MovieRecommenderSystemApplication.class, args);
        System.out.println("Constructor Injection in RecommenderImplemtation class");

        // retrieve singleton bean from application context
        ContentBasedFilter filter = appContext.getBean(ContentBasedFilter.class);
        System.out.println("Content based filter with SIngleton Scope");
        System.out.println(filter);

        // Retrieve Proptotype bean from the singleton bean thrice
        Movie movie1 = filter.getMovie();
        Movie movie2 = filter.getMovie();
        Movie movie3 = filter.getMovie();

        System.out.println("Movie bean with prototype scope");
        System.out.println(movie1);
        System.out.println(movie2);
        System.out.println(movie3);

        // Print instamces of each movie
        System.out.println("contentbasedFilter instances created " + ContentBasedFilter.getInstances());
        System.out.println("Movie instances created " + Movie.getInstances());

    }
}
