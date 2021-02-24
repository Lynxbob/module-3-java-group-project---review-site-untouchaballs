package org.wecancodeit.reviews;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import org.wecancodeit.reviews.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    Optional<Review> findByTitle(String title);
}
