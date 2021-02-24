package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Service
public class ReviewStorage {
    private ReviewRepository reviewRepo;


    public ReviewStorage(ReviewRepository reviewRepo){
        this.reviewRepo = reviewRepo;
    }

    public void saveReview(Review review){
        reviewRepo.save(review);

    }

    public Iterable<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    public Review retrieveReviewByTitle(String title) {
        Review retrievedReview;
        Optional<Review> reviewOptional = reviewRepo.findByTitle(title);
        if(!reviewOptional.isEmpty()) {
            retrievedReview = reviewOptional.get();
        }
        else {
            retrievedReview = null;
        }

        return retrievedReview;
    }
}

