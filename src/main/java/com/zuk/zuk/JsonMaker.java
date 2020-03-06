package com.zuk.zuk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonMaker {
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonInString = "";

    public String listToJson(List list) {
        jsonInString = "";
        try {
            jsonInString = objectMapper.writeValueAsString(list);
        } catch (
                JsonProcessingException e) {
            System.out.println("error with json");
            e.printStackTrace();
        }
        return jsonInString;
    }

}
