package org.wecancodeit.reviews.storage;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import org.wecancodeit.reviews.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    Optional<Review> findByTitle(String title);
}
