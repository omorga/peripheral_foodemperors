package com.isssr.foodemperors.endpoint;


import com.isssr.foodemperors.dto.CategoryDTO;

import com.isssr.foodemperors.model.Category;
import com.isssr.foodemperors.repository.CategoryRepository;
import com.isssr.foodemperors.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.List;


/**
 * Created by marco on 03/06/17.
 */
@RestController
@CrossOrigin(origins = "*")
public class CategoryEndpoint {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private CategoryService categoryService;

    @RequestMapping(path = "api/category", method = RequestMethod.POST)
    public Category saveCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.insertCategory(categoryDTO.getCategory(),categoryDTO.getFather());
    }

    @RequestMapping(path = "api/category/findby/name/{name}", method = RequestMethod.GET)
    public Category searchProduct(@PathVariable String name) {
        return categoryRepository.findById(name);

    }

    @RequestMapping(path = "api/categories/leaf",method = RequestMethod.GET)
    public List<Category> findLeafs(){
        return categoryRepository.findBySons(null);
    }

    @RequestMapping(path = "api/categories/properties/{category}",method = RequestMethod.GET)
    public HashMap<String, String> findProperties(@PathVariable String category){
        return categoryService.getCategories(category);
    }

    @RequestMapping(path = "api/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @RequestMapping(path = "api/categories/root", method = RequestMethod.GET)
    public List<Category> findRoots(){
        return categoryService.getRootsCategories();
    }

}