package com.isssr.foodemperors.repository;

import com.isssr.foodemperors.model.Batch;
import com.isssr.foodemperors.model.BatchesRelation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by simone on 23/06/17.
 */
public interface BatchesRelationRepository extends MongoRepository<BatchesRelation, Long> {

    BatchesRelation findByBatch(Batch batch);

    BatchesRelation findByBatchId(String id);

}
