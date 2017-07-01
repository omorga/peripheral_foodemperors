package com.isssr.foodemperors.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.isssr.foodemperors.config.AppConfig;
import com.isssr.foodemperors.dto.CommissionDTO;
import com.isssr.foodemperors.model.Commission;
import com.isssr.foodemperors.service.CommissionService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommissionEndpoint {

    @Inject
    private CommissionService commissionService;

    public void setMapper(){
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @RequestMapping(path = "api/commission", method = RequestMethod.POST)
    public Commission saveCommission(@RequestBody CommissionDTO commissionDTO,HttpServletRequest request, HttpServletResponse response){


        CommissionDTO dt = commissionService.saveCommission(commissionDTO.getCommission(),commissionDTO.getBatches());
//        CommissionDTO dt = commissionService.searchCommissionByNumber(commissionDTO.getCommission().getNumber());
        this.setMapper();
        try {
            HttpResponse<com.mashape.unirest.http.JsonNode> postResponse = Unirest.post(AppConfig.MC_IP + "/api/pos/commission")
                    .header("Content-Type", "application/json")
                    .body(dt)
                    .asJson();
            if(postResponse.getStatus()>=400) {
                long b= commissionService.deleteCommission(dt.getCommission().getId());
                response.setStatus(postResponse.getStatus());
            }
        } catch (UnirestException e) {
            commissionService.deleteCommission(dt.getCommission().getId());
            response.setStatus(500);
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(path = "api/mc/commission", method = RequestMethod.PUT)
    public Commission updateCommission(@RequestBody CommissionDTO commissionDTO){
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

}
