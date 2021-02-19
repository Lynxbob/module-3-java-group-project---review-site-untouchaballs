package org.wecancodeit.reviews;

import java.util.ArrayList;
import java.util.Collection;

public class Category {
    private String name;
    private String imageUrl;
    private Collection<String> reviews;



    public Category(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.reviews = new ArrayList<>();

    }


    public String getName() {
        return name;
    }

    public Collection<String> getReviews() {
        return reviews;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void addToReviews(String reviewName) {
        reviews.add(reviewName);
      
    }

}
