package org.wecancodeit.reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.wecancodeit.reviews.*;

@Component
public class Populator implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ReviewRepository reviewRepo;

    public Populator(CategoryRepository categoryRepo, ReviewRepository reviewRepo) {
        this.categoryRepo = categoryRepo;
        this.reviewRepo = reviewRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Category miami = new Category("Miami", "images/miami_cropped.jpg");
        Category columbus = new Category("Columbus", "images/columbus.jpg");
//        miami.addToReviews("Wynwood Walls");
//        miami.addToReviews("Lincoln Rd");
//        miami.addToReviews("Brickell Area");

        Review review = new Review("Wynwood Walls", ("Located in a neighborhood between the design district and downtown, Wynwood has become a haven for aspiring painters, graffiti artists, creatives and young innovators alike. \n" +
                "It's filled with beautiful art galleries with known artist from all over the world, and as visitors walk through the streets of this lively neighborhood, murals decorate it's wall making it a unique experience.\n" +
                "You can find high end restaurants as well as food trucks with a variety of type of food. \n" +
                "Every second Saturday of the month, the neighborhood has an event called \"Art Walk\" where galleries are open until midnight and local artist setup shops in an open area, bazar alike. "), "/images/Brickell.jpg", miami);

        categoryRepo.save(miami);
        categoryRepo.save(columbus);
        reviewRepo.save(review);




    }
}
