package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    private CategoryStorage categoryStorage;
    private HashtagStorage hashtagStorage;

    public HomePageController(CategoryStorage categoryStorage, HashtagStorage hashtagStorage) {
        this.categoryStorage = categoryStorage;
        this.hashtagStorage = hashtagStorage;
    }
    @RequestMapping("/")
    public String displayHomePage(Model model) {
        model.addAttribute("categories", categoryStorage);
        model.addAttribute("hashtags", hashtagStorage);

        return "index";
    }
}
