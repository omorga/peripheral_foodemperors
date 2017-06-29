package com.isssr.foodemperors.repository;

import com.isssr.foodemperors.model.Catalogue;
import com.isssr.foodemperors.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by simone on 09/06/17.
 */
public interface CatalogueRepository  extends MongoRepository<Catalogue, Long> {

    Catalogue findByProductId(String Id);
    Catalogue findById(String id);

}