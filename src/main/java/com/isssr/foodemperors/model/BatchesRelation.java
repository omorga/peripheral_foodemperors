package com.isssr.foodemperors.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.*;
import java.util.List;

/**
 * Created by simone on 23/06/17.
 */
@Entity
public class BatchesRelation {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private String id;

    @OneToOne
    @JsonProperty
    @DBRef
    private Batch batch;


    @JsonProperty
    @OneToMany
    @DBRef
    private List<Batch> outBatches;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch Batch) {
        this.batch = Batch;
    }

    public List<Batch> getOutBatches() {
        return outBatches;
    }

    public void setOutBatches(List<Batch> outBatches) {
        this.outBatches = outBatches;
    }
}
