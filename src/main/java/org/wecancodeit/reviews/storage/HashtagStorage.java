package org.wecancodeit.reviews.storage;

import org.hibernate.service.spi.OptionallyManageable;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.exceptions.ResourceNotFoundException;
import org.wecancodeit.reviews.models.Hashtag;
import org.wecancodeit.reviews.storage.HashtagRepository;

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

    public boolean doesHashtagExist(String name) {
        Optional<Hashtag> hashtagOptional = hashtagRepo.findByName(name);
        return !hashtagOptional.isEmpty();
    }
}


