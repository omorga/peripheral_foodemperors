package com.isssr.foodemperors.endpoint;

import com.isssr.foodemperors.dto.CommissionDTO;
import com.isssr.foodemperors.model.Commission;
import com.isssr.foodemperors.service.CommissionService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by marco on 26/05/17.
 */
@RestController
@CrossOrigin(origins = "*")
public class CommissionEndpoint {

    @Inject
    private CommissionService commissionService;

    @RequestMapping(path = "api/commission", method = RequestMethod.POST)
    public Commission saveCommission(@RequestBody CommissionDTO commissionDTO) {
        return commissionService.saveCommission(commissionDTO.getCommission(),commissionDTO.getBatches());
    }

    @RequestMapping(path = "api/commission", method = RequestMethod.PUT)
    public Commission updateCommission(@RequestBody CommissionDTO commissionDTO) {
        return commissionService.updateCommission(commissionDTO.getCommission(),commissionDTO.getBatches());
    }


    @RequestMapping(path = "api/commission/findby/number/{number}", method = RequestMethod.GET)
    public CommissionDTO searchCommissionByNumber(@PathVariable int number) {
        return commissionService.searchCommissionByNumber(String.valueOf(number));

    }

    @RequestMapping(path = "api/commissions", method = RequestMethod.GET)
    public List<CommissionDTO> getAllCommissions() {
        return commissionService.getAllCommissions();
    }

    @RequestMapping(path = "api/commission/{id}", method = RequestMethod.DELETE)
    public Long deleteCommission(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        return commissionService.deleteCommission(id);
    }
}
