package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.models.Comment;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CommentStorage;
import org.wecancodeit.reviews.storage.HashtagStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Controller
public class ReviewPageController {

    private ReviewStorage reviewStorage;
    private CommentStorage commentStorage;
    private HashtagStorage hashtagStorage;

    public ReviewPageController(ReviewStorage reviewStorage, CommentStorage commentStorage, HashtagStorage hashtagStorage) {
        this.reviewStorage = reviewStorage;
        this.commentStorage = commentStorage;
        this.hashtagStorage = hashtagStorage;
    }

    @RequestMapping("/cities/{categoryTitle}/{reviewTitle}")
    public String displayReviewPage(@PathVariable String categoryTitle, @PathVariable String reviewTitle, Model model) {

        Review review = reviewStorage.retrieveReviewByTitle(reviewTitle);

        model.addAttribute("review", review);
        return "review-page";

    }

    @PostMapping("/cities/{categoryTitle}/{reviewTitle}/add-hashtag")
    public String addHashtag(@PathVariable String categoryTitle, @PathVariable String reviewTitle, String hashtag) {
        Hashtag hash;
        hashtag = hashtag.replace("#", "");
        Review review = reviewStorage.retrieveReviewByTitle(reviewTitle);
        if(hashtagStorage.doesHashtagExist(hashtag)) {
            hash = hashtagStorage.retrieveHashtagByName(hashtag);
            if(!hash.getReviews().contains(review)) {
                hash.addReview(review);
                hashtagStorage.saveHashtag(hash);
            }

        }
        else {
            if(hashtag.length() != 0) {
                hash = new Hashtag(hashtag);
                hash.addReview(review);
                hashtagStorage.saveHashtag(hash);
            }
        }



        return "redirect:/cities/" + categoryTitle + "/" + reviewTitle + "/#review__hashtag";
    }

    @PostMapping("/cities/{categoryTitle}/{reviewTitle}/add-comment")
    public String addComment(@PathVariable String categoryTitle ,@PathVariable String reviewTitle, String authorName, String description) {
        Review review = reviewStorage.retrieveReviewByTitle(reviewTitle);
        Comment comment = new Comment(authorName, description, review);

        commentStorage.saveComment(comment);

        return "redirect:/cities/" + categoryTitle + "/" + reviewTitle + "/#comments";


    }
}
