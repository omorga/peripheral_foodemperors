package com.isssr.foodemperors.service;

import com.isssr.foodemperors.dto.CommissionDTO;
import com.isssr.foodemperors.model.Batch;
import com.isssr.foodemperors.model.Commission;
import com.isssr.foodemperors.repository.BatchRepository;
import com.isssr.foodemperors.repository.CommissionRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marco on 13/06/17.
 */
@Service
public class CommissionService {

    @Inject
    private CommissionRepository commissionRepository;

    @Inject
    private BatchRepository batchRepository;

    public Commission saveCommission(Commission commission, List<Batch> batches){
        Commission comm = commissionRepository.save(commission);
        comm.setCompleted(false);
        for (Batch batch: batches){
            batch.setCommission(comm);
            batch.setStatus(0);
            batchRepository.save(batch);
        }
        return comm;
    }

    public Commission updateCommission(Commission commission,List<Batch> batches){
        Commission comm = commissionRepository.save(commission);
        List<Batch> oldBatches = batchRepository.findByCommissionId(comm.getId());
        for (Batch batch: batches){
            if (batch.getCommission() == null)
                batch.setCommission(comm);
            batchRepository.save(batch);
        }
        for (Batch batch : oldBatches){
            boolean found = false;
            for (int i = 0 ; i < batches.size() && !found; i++){
                found = (batch.getId().equals(batches.get(i).getId()));
            }
            if (!found)
                batchRepository.deleteById(batch.getId());
        }
        return comm;
    }

    public CommissionDTO searchCommissionByNumber(String number) {
        Commission commission = commissionRepository.findByNumber(number);
        CommissionDTO commissionDTO = new CommissionDTO();
        commissionDTO.setCommission(commission);
        commissionDTO.setBatches(batchRepository.findByCommissionId(commission.getId()));
        return commissionDTO;

    }

    public List<CommissionDTO> getAllCommissions() {
        List<Commission> commissions = commissionRepository.findAll();
        List<CommissionDTO> dtoCommissions = new ArrayList<>();
        for (Commission cms: commissions){
            CommissionDTO cDTO = new CommissionDTO();
            cDTO.setCommission(cms);
            cDTO.setBatches(batchRepository.findByCommissionId(cms.getId()));
            dtoCommissions.add(cDTO);
        }
        return dtoCommissions;
    }

    public Long deleteCommission(String id) {
        batchRepository.deleteByCommissionId(id);
        return commissionRepository.deleteById(id);
    }
}
