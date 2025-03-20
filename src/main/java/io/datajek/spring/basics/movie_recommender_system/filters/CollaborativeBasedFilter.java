package io.datajek.spring.basics.movie_recommender_system.filters;

import org.springframework.beans.factory.config.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

@Component
//@Scope("prototype")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CollaborativeBasedFilter implements Filter {
    public CollaborativeBasedFilter() {
        System.out.println("hello from collaborative");
    }

    @Override
    public String[] getRecommendations(String movie){
        return new String[]{"Finding Nemo", "Ice Age", "Toy Story"};
    }
}
