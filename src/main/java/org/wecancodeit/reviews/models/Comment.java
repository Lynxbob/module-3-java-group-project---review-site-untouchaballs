package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

    @GeneratedValue
    @Id
    private long id;
    private String authorName;
    private String description;
    @ManyToOne
    private Review review;

    public Comment(String authorName, String description, Review review) {
        this.authorName = authorName;
        this.description = description;
        this.review = review;
    }
    protected Comment() {

    }

    public long getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getDescription() {
        return description;
    }

    public Review getReview() {
        return review;
    }
}
