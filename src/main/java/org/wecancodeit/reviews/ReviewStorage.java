package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


    @Service
    public class ReviewStorage {
        private Map<String, Review> reviews;


        public ReviewStorage(){
            reviews = new HashMap<>();

        }

        public void saveReview(Review review){
            reviews.put(review.getTitle(), review);

        }

        public Review retrieveReviewByTitle(String title) {
            return reviews.get(title);
        }
    }

