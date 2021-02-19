package org.wecancodeit.reviews;

import java.util.ArrayList;
import java.util.Collection;

public class Category {
    private String name;
    private String imageUrl;
    private Collection<Review> reviews;



    public Category(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.reviews = new ArrayList<>();

    }


    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void addToReviews(Review review) {
        reviews.add(review);
    }

}
