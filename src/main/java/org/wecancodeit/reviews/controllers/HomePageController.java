package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.CategoryStorage;
import org.wecancodeit.reviews.storage.HashtagStorage;

@Controller
public class HomePageController {

    private CategoryStorage categoryStorage;
    private HashtagStorage hashtagStorage;

    public HomePageController(CategoryStorage categoryStorage, HashtagStorage hashtagStorage) {
        this.categoryStorage = categoryStorage;
        this.hashtagStorage = hashtagStorage;
    }
    @RequestMapping("/hikers-guide")
    public String displayHomePage(Model model) {
        model.addAttribute("categories", categoryStorage);
        model.addAttribute("hashtags", hashtagStorage);

        return "index";
    }

    @PostMapping("/add-hashtag")
    public String addHashtag(String hashtag) {
        hashtag = hashtag.replace("#","");
        if(hashtagStorage.retrieveHashtagByName(hashtag) == null) {
            if(hashtag.length() !=0) {
                Hashtag hash = new Hashtag(hashtag);
                hashtagStorage.saveHashtag(hash);
            }
        }

        return "redirect:/#hashtags__title";

    }
}
