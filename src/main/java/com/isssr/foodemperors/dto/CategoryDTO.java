package com.isssr.foodemperors.dto;

import com.isssr.foodemperors.model.Category;

/**
 * Created by marco on 06/06/17.
 */
public class CategoryDTO {

    private Category category;

    private String father;



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

}
