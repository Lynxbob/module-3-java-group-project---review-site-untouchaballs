package org.wecancodeit.reviews.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String imageUrl;

    @OneToMany(mappedBy = "category")
    private Collection<Review> reviews;


    protected Category(){

    }

    public Category(String name, String imageUrl) {
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

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", reviews=" + reviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return imageUrl != null ? imageUrl.equals(category.imageUrl) : category.imageUrl == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        return result;
    }
}
