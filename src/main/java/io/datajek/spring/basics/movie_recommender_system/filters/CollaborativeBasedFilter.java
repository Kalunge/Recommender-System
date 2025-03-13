package io.datajek.spring.basics.movie_recommender_system.filters;

public class CollaborativeBasedFilter implements Filter {
    @Override
    public String[] getRecommendations(String movie){
        return new String[]{"Finding Nemo", "Ice Age", "Toy Story"};
    }
}
