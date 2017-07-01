package com.isssr.foodemperors.repository;

import com.isssr.foodemperors.model.Commission;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommissionRepository extends MongoRepository<Commission, Long> {

    Commission findByNumber(String Number);
    Commission findById(String Id);
    Long deleteById(String Id);

}