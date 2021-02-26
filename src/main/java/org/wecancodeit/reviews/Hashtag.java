package org.wecancodeit.reviews;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String hashtag;

    @ManyToMany
    private Collection<Review> reviews;

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public Hashtag(String name) {
        this.name = name;
        this.reviews = new ArrayList<>();
        this.hashtag = "#";
    }


    public void addReview(Review review) {
        reviews.add(review);
    }

    protected Hashtag() {}

    public long getId() {
        return id;
    }

    public String getHashtag() {
        return hashtag;
    }

    public String getName() {
        return name;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}
