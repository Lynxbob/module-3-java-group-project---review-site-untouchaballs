package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HashtagStorage {

    private HashtagRepository hashtagRepo;

    public HashtagStorage(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    public void saveHashtag(Hashtag hashtag){
        hashtagRepo.save(hashtag);

    }

    public Iterable<Hashtag> getAllHashtags() {
        return hashtagRepo.findAll();
    }

    public Hashtag retrieveHashtagByName(String name) {
        Hashtag retrievedHashtag;
        Optional<Hashtag> hashtagOptional = hashtagRepo.findByName(name);
        if(!hashtagOptional.isEmpty()) {
            retrievedHashtag = hashtagOptional.get();
        }
        else {
            retrievedHashtag = null;
        }

        return retrievedHashtag;
    }
}


