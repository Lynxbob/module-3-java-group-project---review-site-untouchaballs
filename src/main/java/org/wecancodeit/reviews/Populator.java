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
        Category charleston = new Category("Charleston","images/charleston_syline.jpg");
        Category sanFrancisco = new Category("San Francisco","images/san_francisco.jpg");


        Review wynwoodWalls = new Review("Wynwood Walls", ("Located in a neighborhood between the design district and downtown, Wynwood has become a haven for aspiring painters, graffiti artists, creatives and young innovators alike. \n" +
                "It's filled with beautiful art galleries with known artist from all over the world, and as visitors walk through the streets of this lively neighborhood, murals decorate it's wall making it a unique experience.\n" +
                "You can find high end restaurants as well as food trucks with a variety of type of food. \n" +
                "Every second Saturday of the month, the neighborhood has an event called \"Art Walk\" where galleries are open until midnight and local artist setup shops in an open area, bazaar alike. "), "/images/Brickell.jpg", miami);

        Review lincolnRoad = new Review("Lincoln Rd",("Lincoln Rd is a ten-block mecca of shopping dining and entertainment that is constantly filled with a mix of tourists and locals which creates an ultimately energy for people-watching.\n" +
                "During the day is the perfect place to walk down the road with family and friends. The outdoor sitting provided by restaurants gives you that unique experience of enjoying a nice meal, while watching people from all over the world walk by.\n" +
                "At night the scene changes, where you can come with your friends to enjoy some drinks or gather at one of its famous Hookah bars. \n" +
                "During the weekend night clubs in the road are open for those looking to be part of the party scene that South Beach has to offer.\n"),"/images/Lincoln Rd.jpg",miami);

        Review brickellArea =new Review("Brickell Area",("Brickell offers a dense urban feel to its residents and visitors. For many it's known as the new Manhattan of the south because of its many buildings and being the financial district of Miami.\n" +
                "In Brickell there are a lot of bars, restaurants, coffee shops, and parks. Many young professionals live in Brickell and the area continues to grow its population. \n" +
                "It is a safe area for those that enjoy jogging at any time or exercising at its many recreational parks. "),"/images/Brickell.jpg", miami);

        Review goldenGateBridge = new Review("Golden Gate Bridge", ("Isn’t just one of the most iconic San Francisco attractions—it’s one of the most iconic attractions in the world. In the U.S., the only structure more famous is the Statue of Liberty. So it’d be a crime to visit San Francisco and not make your way across—or at least get a good look at—this stunning bridge, which is truly a sight to behold.\n" +
                "Spanning 1.7 miles from scenic Fort Point to Marin’s headlands, 120,000 cars drive across the Golden Gate Bridge daily. When it debuted in 1937, it cost $0.50 to cross this magnificent landmark by automobile. The toll has since changed (it was $7.75 at publication time) but the awe-inspiring architecture has not. Experience it for free—and see the bay in all its splendor—by walking or biking across.\n"), "/images/Golden Gate Bridge.jpg", sanFrancisco);

        Review chinaTown = new Review("China Town", ("When you’re deciding on places to visit in San Francisco, don’t forego the 24 lively blocks that comprise Chinatown toward the northern end of the city. Enter through “Dragon’s Gate” on Grant Avenue and walk up into these bustling lanes; they’re packed with tourist-friendly shops, colorful markets, authentic restaurants, fragrant tea shops, and small pagodas and temples. Don’t miss the Golden Gate Cookie Factory on Ross Alley, where every day, two women hand make 20,000 fortune cookies.\n"),"/images/China Town.jpg" ,sanFrancisco);

        Review fisherManWharf = new Review("Fisher Man Wharf",("You haven’t gone San Francisco sightseeing if you haven’t seen Fisherman’s Wharf and its festive Pier 39, San Francisco’s most visited destination. Jutting out over the bay, the pier’s carnival-like collection of attractions, food vendors, shops, and live entertainment makes for a very cheerful way to spend a day. Add spectacular ocean views, the fascinating Aquarium of the Bay, plus a hilarious colony of California sea lions on the marina’s western docks, and you’ve got an experience you won’t soon forget.\n" +
                "Step off the pier into Fisherman’s Wharf to see talented street buskers, stands selling hot clam chowder, and quirky attractions like the Musee Mecanique, Madame Tussauds wax museum, Ripley’s Believe It or Not!, and the San Francisco Dungeon.\n"), "images/wharf.jpg", sanFrancisco);







        categoryRepo.save(miami);
        categoryRepo.save(columbus);
        categoryRepo.save(charleston);
        categoryRepo.save(sanFrancisco);

        reviewRepo.save(wynwoodWalls);
        reviewRepo.save(lincolnRoad);
        reviewRepo.save(brickellArea);

        reviewRepo.save(goldenGateBridge);
        reviewRepo.save(chinaTown);
        reviewRepo.save(fisherManWharf);




    }
}
