package com.isssr.foodemperors.service;

import com.isssr.foodemperors.model.Category;
import org.springframework.stereotype.Service;
import com.isssr.foodemperors.repository.CategoryRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by marco on 13/06/17.
 */
@Service
public class CategoryService {

    @Inject
    private CategoryRepository categoryRepository;

    public Category insertCategory(Category category, String father){
        if (father == null){
            return categoryRepository.save(category);
        }
        Category fatherCategory = categoryRepository.findById(father);
        List<Category> sons = fatherCategory.getSons();
        if (sons == null)
            sons = new ArrayList<>();
        sons.add(category);
        fatherCategory.setSons(sons);
        categoryRepository.save(fatherCategory);
        category.setFather(fatherCategory);
        return categoryRepository.save(category);
    }

    public HashMap<String, String> getCategories (String cat) {
        Category category = categoryRepository.findById(cat);
        HashMap<String,String> map = category.getProperties();
        while (category.getFather() == null){
            category = categoryRepository.findById(category.getFatherId());
            map.putAll(category.getProperties());
        }
        return map;
    }

    public List<Category> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }

    public List<Category> getRootsCategories() {
        return categoryRepository.findByFather(null);
    }

    public List<Category> findLeafs(Object o) {
        return categoryRepository.findBySons(null);
    }

    public Category findById(String name) {
        return categoryRepository.findById(name);
    }
}
