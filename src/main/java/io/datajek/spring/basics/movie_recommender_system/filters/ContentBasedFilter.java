package io.datajek.spring.basics.movie_recommender_system.filters;

import io.datajek.spring.basics.movie_recommender_system.movies.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ContentBasedFilter implements Filter {
    private static int instances = 0;

    @Autowired
    private Movie movie;

    public ContentBasedFilter() {
        instances++;
        System.out.println("ContentBased filter constructor called");
    }

    @Lookup
    public Movie getMovie() {
        return movie;
    }

    public static int getInstances() {
        return ContentBasedFilter.instances;
    }

    @Override
    public String[] getRecommendations(String move) {
        return new String[]{"CbFmovie1", "CbFmovie2", "CbFmovie3"};
    }
}
