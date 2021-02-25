package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class ReviewPageController {

    private ReviewStorage reviewStorage;

    public ReviewPageController(ReviewStorage reviewStorage) {
        this.reviewStorage = reviewStorage;
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
}
