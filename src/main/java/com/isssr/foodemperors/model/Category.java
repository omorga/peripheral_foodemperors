package com.isssr.foodemperors.model;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by marco on 03/06/17.
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private String id;

    @Embedded
    @JsonProperty
    private HashMap<String,String> properties;



    @ManyToOne
    @JoinColumn(name = "id_father")
    @DBRef
    @JsonIgnore
    private Category father;

    @OneToMany
    @JoinColumn(name = "id_sons")
    @DBRef
    private List<Category> sons;


    public Category(){

    }

    public Category(String id, HashMap<String,String> properties){
        this.id = id;
        this.properties = properties;
        this.sons = new ArrayList<>();

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }


    public Category getFather() {
        return father;
    }

    public void setFather(Category father) {
        this.father = father;
    }

    public List<Category> getSons() {
        return sons;
    }

    public void setSons(List<Category> sons) {
        this.sons = sons;
    }

    @JsonGetter
    public String getFatherId(){
        if(this.getFather() != null)
        return this.getFather().getId();
        else
            return null;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", properties=" + properties +
                ", father=" + father +
                ", sons=" + sons +
                '}';
    }
}
