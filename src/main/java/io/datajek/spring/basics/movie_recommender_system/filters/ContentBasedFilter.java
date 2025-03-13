package io.datajek.spring.basics.movie_recommender_system.filters;

public class ContentBasedFilter implements Filter {
    public String[] getRecommendations(String movie) {
        return new String[]{"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
