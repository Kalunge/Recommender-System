package io.datajek.spring.basics.movie_recommender_system.filters;

import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ContentBasedFilter implements Filter {

    public ContentBasedFilter() {
        System.out.println("hello from content based");
    }

    public String[] getRecommendations(String movie) {
        return new String[]{"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
