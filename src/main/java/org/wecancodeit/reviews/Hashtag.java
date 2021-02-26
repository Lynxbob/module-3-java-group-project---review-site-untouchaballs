package org.wecancodeit.reviews;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany
    private Collection<Review> reviews;

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public Hashtag(String name) {
        this.name = name;
        this.reviews = new ArrayList<Review>();
    }

    protected Hashtag() {}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }
}
