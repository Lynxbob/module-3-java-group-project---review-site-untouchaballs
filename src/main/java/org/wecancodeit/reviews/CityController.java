package org.wecancodeit.reviews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class CityController {


    @RequestMapping("/review-page")
    public String displayReviewPage(Model model) {
        Review review = new Review("Wynwood Walls", "Located in a neighborhood between the\n" +
                "                    design district and downtown, Wynwood has become a haven for aspiring painters, graffiti artists,\n" +
                "                    creatives and young innovators alike.\n" +
                "                    It's filled with beautiful art galleries with known artist from all over the world, and as visitors\n" +
                "                    walk through the streets of this lively neighborhood, murals decorate it's wall making it a unique\n" +
                "                    experience.\n" +
                "                    You can find high end restaurants as well as food trucks with a variety of type of food.\n" +
                "                    Every second Saturday of the month, the neighborhood has an event called \"Art Walk\" where galleries\n" +
                "                    are open until midnight and local artist setup shops in an open area, bazar alike.", "static/images/Wynwood.jpg", "Miami");


        model.addAttribute("review", review);
        return "review-page";

    }
}
