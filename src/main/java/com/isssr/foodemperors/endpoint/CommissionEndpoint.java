package com.isssr.foodemperors.endpoint;

import com.fasterxml.jackson.databind.JsonNode;
import com.isssr.foodemperors.dto.CommissionDTO;
import com.isssr.foodemperors.model.Commission;
import com.isssr.foodemperors.service.CommissionService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommissionEndpoint {

    @Inject
    private CommissionService commissionService;

    @RequestMapping(path = "api/commission", method = RequestMethod.POST)
    public Commission saveCommission(@RequestBody CommissionDTO commissionDTO){
        try {
            HttpResponse<com.mashape.unirest.http.JsonNode> postResponse = Unirest.post("http://localhost:8080/api/pos/commissions")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(commissionDTO)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return commissionService.saveCommission(commissionDTO.getCommission(),commissionDTO.getBatches());
    }

    @RequestMapping(path = "api/commission/findby/number/{number}", method = RequestMethod.GET)
    public CommissionDTO searchCommissionByNumber(@PathVariable int number) {
        return commissionService.searchCommissionByNumber(String.valueOf(number));

    }

    @RequestMapping(path = "api/commissions", method = RequestMethod.GET)
    public List<CommissionDTO> getAllCommissions() {
        return commissionService.getAllCommissions();
    }

}
