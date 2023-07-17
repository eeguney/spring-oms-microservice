package com.ordermanagement.orderservice.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonConverterUtil {
    public String execute(Object object) throws JsonProcessingException {
       return new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(object);
    }

}
