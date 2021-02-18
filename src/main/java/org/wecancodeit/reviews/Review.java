package org.wecancodeit.reviews;

public class Review {
    private String title;
    private String description;
    private String imageUrl;
    private String categoryName;


    public Review(String title, String description, String imageUrl, String categoryName) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }
}
