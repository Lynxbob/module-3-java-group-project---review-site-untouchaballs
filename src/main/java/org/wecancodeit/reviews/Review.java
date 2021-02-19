package org.wecancodeit.reviews;

public class Review {
    private String title;
    private String description;
    private String imageUrl;
    private Category category;


    public Review(String title, String description, String imageUrl, Category category) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.category.getReviews().add(this);
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
}
