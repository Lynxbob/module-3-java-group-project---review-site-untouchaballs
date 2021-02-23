package org.wecancodeit.reviews;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class CategoryStorage {
    private Map<String, Category> categories;


    public CategoryStorage(){
        categories = new HashMap<>();

    }

    public void saveCategory(Category category){
        categories.put(category.getName(), category);

    }

    public Map<String, Category> getCategories() {
        return categories;
    }

    public Category retrieveCategoryByTitle(String title) {
        return categories.get(title);
    }
}
