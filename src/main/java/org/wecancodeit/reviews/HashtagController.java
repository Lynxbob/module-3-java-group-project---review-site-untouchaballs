package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HashtagController {

    private HashtagStorage hashtagStorage;

    public HashtagController(HashtagStorage hashtagStorage) {
        this.hashtagStorage = hashtagStorage;
    }


    @RequestMapping("/hashtags/{hashtagName}")
    public String displayHashtagReviews(@PathVariable String hashtagName, Model model) {

        Hashtag hashtag = hashtagStorage.retrieveHashtagByName(hashtagName);
        model.addAttribute("hashtag", hashtag);


        return "hashtag-page";
    }
}
