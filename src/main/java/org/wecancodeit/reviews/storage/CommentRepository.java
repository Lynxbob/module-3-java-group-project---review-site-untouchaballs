package org.wecancodeit.reviews.storage;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviews.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
