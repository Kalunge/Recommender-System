package io.datajek.spring.basics.movie_recommender_system.filters;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
@Component
public class ContentBasedFilter implements Filter {
    public String[] getRecommendations(String movie) {
        return new String[]{"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
