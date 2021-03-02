package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.ReviewStorage;

@Controller
public class EditReviewController {

    private CategoryStorage categoryStorage;
    private ReviewStorage reviewStorage;

    public EditReviewController(CategoryStorage categoryStorage, ReviewStorage reviewStorage) {
        this.categoryStorage = categoryStorage;
        this.reviewStorage = reviewStorage;
    }


    @RequestMapping("/add-review")
    public String addReview(Model model) {
        model.addAttribute("categories",categoryStorage);

        return "add-review";
    }

    @PostMapping("/add-review/success")
    public String processNewReview(int category, String reviewName, String reviewDesc, String reviewImg) {
        Category newCategory = categoryStorage.retrieveById(category);
        Review review = new Review(reviewName,reviewDesc,reviewImg, newCategory);
        reviewStorage.saveReview(review);

        return "redirect:/add-review/review-submitted";
    }

    @RequestMapping("/add-review/review-submitted")
    public String showReviewSubmitted(Model model) {
        return "review-submitted";
    }


}
