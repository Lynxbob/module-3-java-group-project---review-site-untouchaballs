package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
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

    public Category retrieveCategoryByName(String name) {
        Category retrievedCategory;
        Optional<Category> categoryOptional = categoryRepo.findByName(name);
        if(!categoryOptional.isEmpty()) {
            retrievedCategory = categoryOptional.get();
        }
        else {
            retrievedCategory = null;
        }

        return retrievedCategory;

    }
}
