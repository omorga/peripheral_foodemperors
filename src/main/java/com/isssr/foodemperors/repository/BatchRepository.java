package com.isssr.foodemperors.repository;

import com.isssr.foodemperors.model.Batch;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by marco on 26/05/17.
 */
public interface BatchRepository extends MongoRepository<Batch, Long> {

    List<Batch> findByCommissionId(String Id);

    List<Batch> findByProductId(String Id);
    Long deleteByCommissionId(String Id);
    Long deleteById(String Id);
    List<Batch> findByRemainingGreaterThanEqual(Integer remaining);
}