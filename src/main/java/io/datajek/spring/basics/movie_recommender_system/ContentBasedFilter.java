package io.datajek.spring.basics.movie_recommender_system;

public class ContentBasedFilter {
    public String[] getRecommendations(String movie){
        return new String[]{"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
