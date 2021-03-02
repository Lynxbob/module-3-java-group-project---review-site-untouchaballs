package org.wecancodeit.reviews.models;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Column(length=1000)
    private String description;
    private String imageUrl;

    @ManyToMany(mappedBy = "reviews")
    private Collection<Hashtag> hashtags;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "review")
    private Collection<Comment> comments;

    protected Review() {
    }


    public Review(String title, String description, String imageUrl, Category category) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.hashtags = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public void addHashtag(Hashtag hashtag) {
        hashtags.add(hashtag);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public long getId() {
        return id;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Review review = (Review) o;

        if (id != review.id) return false;
        if (title != null ? !title.equals(review.title) : review.title != null) return false;
        if (description != null ? !description.equals(review.description) : review.description != null) return false;
        if (imageUrl != null ? !imageUrl.equals(review.imageUrl) : review.imageUrl != null) return false;
        return category != null ? category.equals(review.category) : review.category == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
