package org.wecancodeit.reviews;

import java.util.ArrayList;
import java.util.Collection;

public class City {
    private String name;
    private Collection<Review> reviews;
    private String imageUrl;



    public City(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.reviews = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void addToReviews(Review review) {
        reviews.add(review);
    }

}
