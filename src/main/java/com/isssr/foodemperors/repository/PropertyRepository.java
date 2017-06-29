package com.isssr.foodemperors.repository;

import com.isssr.foodemperors.model.Property;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Caim03 on 12/06/17.
 */

public interface PropertyRepository extends MongoRepository<Property, Long>{

    Property findById(String id);
}
