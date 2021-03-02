package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.wecancodeit.reviews.models.Comment;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CommentStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Controller
public class ReviewPageController {

    private ReviewStorage reviewStorage;
    private CommentStorage commentStorage;

    public ReviewPageController(ReviewStorage reviewStorage, CommentStorage commentStorage) {
        this.reviewStorage = reviewStorage;
        this.commentStorage = commentStorage;
    }

    @RequestMapping("/cities/{categoryTitle}/{reviewTitle}")
    public String displayReviewPage(@PathVariable String categoryTitle, @PathVariable String reviewTitle, Model model) {

        Review review = reviewStorage.retrieveReviewByTitle(reviewTitle);
        if(review == null) {
            return "error";
        }



        model.addAttribute("review", review);
        return "review-page";

    }


    @PostMapping("/cities/{categoryTitle}/{reviewTitle}/add-comment")
    public String addComment(@PathVariable String categoryTitle ,@PathVariable String reviewTitle, String authorName, String description) {
        Review review = reviewStorage.retrieveReviewByTitle(reviewTitle);
        Comment comment = new Comment(authorName, description, review);

        commentStorage.saveComment(comment);

        return "redirect:/cities/" + categoryTitle + "/" + reviewTitle + "/#comments";


    }
}
