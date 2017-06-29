package com.isssr.foodemperors.service;

import com.isssr.foodemperors.model.BatchesRelation;
import com.isssr.foodemperors.repository.BatchesRelationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by simone on 23/06/17.
 */
@Service
public class BatchesRelationService {

    @Inject
    BatchesRelationRepository batchesRelationRepository;

    public BatchesRelation saveBatch(BatchesRelation batchesRelation) {
        return batchesRelationRepository.save(batchesRelation);
    }


    public List<BatchesRelation> getBatchesRelation() {
        return batchesRelationRepository.findAll();
    }
}
