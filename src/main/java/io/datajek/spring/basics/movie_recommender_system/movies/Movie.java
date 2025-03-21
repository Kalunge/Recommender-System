package io.datajek.spring.basics.movie_recommender_system.movies;

import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Movie {
    private static int instances = 0;

    private int id;
    private String name;
    private String genre;
    private String producer;

    public Movie() {
        instances++;
        System.out.println("Movie constructor called");
    }

    public static int getInstances() {
        return Movie.instances;
    }
}
