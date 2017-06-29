package com.isssr.foodemperors.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isssr.foodemperors.model.Batch;
import com.isssr.foodemperors.model.Commission;

import java.util.List;

/**
 * Created by marco on 26/05/17.
 */
public class CommissionDTO {

    @JsonProperty
    private Commission commission;

    @JsonProperty
    private List<Batch> batches;

    public CommissionDTO() {
    }

    public CommissionDTO(Commission commission, List<Batch> batches) {
        this.commission = commission;
        this.batches = batches;
    }

    public List<Batch> getBatches() {
        return batches;
    }

    public void setBatches(List<Batch> batches) {
        this.batches = batches;
    }

    public Commission getCommission() {
        return commission;
    }

    public void setCommission(Commission commission) {
        this.commission = commission;
    }
}
