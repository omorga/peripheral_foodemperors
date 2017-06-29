package com.isssr.foodemperors.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by mariusdragosionita on 23/05/17.
 */
@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private String id;

    @Embedded
    @JsonProperty
    private HashMap<String, String> properties;

    @ManyToMany
    @JoinColumn(name = "id_products")
    @DBRef
    @JsonProperty
    private List<Product> productlist;

    public Property() {}

    public Property(String id, HashMap<String, String> properties, List<Product> productlist) {
        this.id = id;
        this.properties = properties;
        this.productlist = productlist;
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

    public List<Product> getProductlist() {
        return productlist;
    }

    public void setProductlist(List<Product> productlist) {
        this.productlist = productlist;
    }
}
