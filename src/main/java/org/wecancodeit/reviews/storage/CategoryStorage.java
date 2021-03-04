package org.wecancodeit.reviews.storage;

import org.springframework.stereotype.Service;
import org.wecancodeit.reviews.exceptions.ResourceNotFoundException;
import org.wecancodeit.reviews.models.Category;
import org.wecancodeit.reviews.storage.CategoryRepository;

import java.util.Optional;


@Service
public class CategoryStorage {
    private CategoryRepository categoryRepo;


    public CategoryStorage(CategoryRepository categoryRepo){
        this.categoryRepo = categoryRepo;

    }

    public void saveCategory(Category category){
        categoryRepo.save(category);

    }

    public Iterable<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category retrieveById(long id) {
        Category retrievedCategory;
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if(!categoryOptional.isEmpty()) {
            retrievedCategory = categoryOptional.get();
        }
        else {
            retrievedCategory = null;
        }

        return retrievedCategory;
    }
    public Category retrieveCategoryByName(String name) {
        Category retrievedCategory;
        Optional<Category> categoryOptional = categoryRepo.findByName(name);
        if(!categoryOptional.isEmpty()) {
            retrievedCategory = categoryOptional.get();
        }
        else {
            throw new ResourceNotFoundException("City of " + name + " is not in the database or does not exist");
        }

        return retrievedCategory;

    }
}
