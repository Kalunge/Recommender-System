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
        System.out.println("Constructor Injection in RecommenderImplemtation class");

        // retrieve singleton bean from application context thrice
        ContentBasedFilter cbF1 = appContext.getBean(ContentBasedFilter.class);
        ContentBasedFilter cbF2 = appContext.getBean(ContentBasedFilter.class);
        ContentBasedFilter cbF3 = appContext.getBean(ContentBasedFilter.class);

        // Retrieve protptype bean from application context thrice
        CollaborativeBasedFilter cbF4 = appContext.getBean(CollaborativeBasedFilter.class);
        CollaborativeBasedFilter cbF5 = appContext.getBean(CollaborativeBasedFilter.class);
        CollaborativeBasedFilter cbF6 = appContext.getBean(CollaborativeBasedFilter.class);

        System.out.println(cbF4);
        System.out.println(cbF5);
        System.out.println(cbF6);
        // we can use appcontext to find which filter is being used
        RecommenderImplementationV2 recommender2 = appContext.getBean(RecommenderImplementationV2.class);

        RecommenderImplementation recommender = appContext.getBean(RecommenderImplementation.class);


        // call method to get recommendations
        String[] result = recommender.recommendMovies("Finding Dorry");
        String[] result2 = recommender2.recommendMovies("Finding Dorry ");

        System.out.println(Arrays.toString(result) + " ---> Collaborative based");
        System.out.println(Arrays.toString(result2) +" ---> Connentbasedfilter");

    }
}
