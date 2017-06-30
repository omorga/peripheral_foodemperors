package com.isssr.foodemperors.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
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
    public Commission saveCommission(@RequestBody CommissionDTO commissionDTO){
        if (commissionDTO == null)
            System.out.println("Null");
        else
            this.setMapper();
        try {
            HttpResponse<com.mashape.unirest.http.JsonNode> postResponse = Unirest.post("http://160.80.134.103:8080/api/pos/commission")
                    .header("Content-Type", "application/json")
                    .body(commissionDTO)
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(path = "api/mc/commission", method = RequestMethod.POST)
    public Commission storeCommission(@RequestBody CommissionDTO commissionDTO){
        System.out.println("    la commissione :"+commissionDTO);
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
