package com.isssr.foodemperors.endpoint;

import com.isssr.foodemperors.dto.CommissionDTO;
import com.isssr.foodemperors.model.Batch;
import com.isssr.foodemperors.model.Product;
import com.isssr.foodemperors.service.BatchService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by simone on 29/05/17.
 */


@RestController
@CrossOrigin(origins = "*")
public class BatchEndpoint {


    @Inject
    private BatchService batchService;

    /**
     *  Salva i batches aggiornati e restituisce il commissionDTO con la commission aggiornata
     */
    @RequestMapping(path = "api/batch/saveBatches", method = RequestMethod.POST)
    public CommissionDTO saveBatch(@RequestBody ArrayList<Batch> batches) {
        return batchService.saveBatch(batches);
    }

    @RequestMapping(path = "api/batch/getbatchesbyprod", method = RequestMethod.POST)
    public List<Batch> getBatchesByProd(@RequestBody Product product) {
        return batchService.getBatchesByProd(product);

    }

    @RequestMapping(path = "api/batch/sendBatches", method = RequestMethod.POST)
    public List<Batch> sendBatches(@RequestBody List<Batch> batches) {
        return batchService.sendBatches(batches);
    }


    @RequestMapping(path = "api/batches/expiring", method = RequestMethod.GET)
    public List<Batch> getExpiringBatches(){
        return batchService.getExpiringBatches();
    }

    @RequestMapping(path = "api/batches", method = RequestMethod.PUT)
    public List<Batch> updateBatches(@RequestBody List<Batch> batches){
        return batchService.updateBatches(batches);
    }

    @RequestMapping(path = "api/batch/getallbatches", method = RequestMethod.GET)
    public List<Batch> getAllBatches() {
        return batchService.getAllBatches();

    }
}
