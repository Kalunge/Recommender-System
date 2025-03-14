package io.datajek.spring.basics.movie_recommender_system.filters;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

@Component
@Primary
public class CollaborativeBasedFilter implements Filter {
    @Override
    public String[] getRecommendations(String movie){
        return new String[]{"Finding Nemo", "Ice Age", "Toy Story"};
    }
}
