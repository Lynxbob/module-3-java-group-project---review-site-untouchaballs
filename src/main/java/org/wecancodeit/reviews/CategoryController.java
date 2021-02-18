package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {

    @RequestMapping("/categories-page")
    public String displayReviewPage(Model model) {

        Category miami = new Category("Miami", "");
        miami.addToReviews("Wynwood Walls");
        miami.addToReviews("Lincoln Rd");
        miami.addToReviews("Brickell Area");

        model.addAttribute("city", miami);
        return "categories-page";

    }
}
