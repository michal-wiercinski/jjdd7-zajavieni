package com.infoshareacademy;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonToObject {


    public <T> Object convertToObject(String filePathName, Class<T> targetClass) {
        ObjectMapper mapper = new ObjectMapper();

        T outputObject = null;

        try {
            outputObject = mapper.readValue(filePathName, targetClass);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputObject;
    }
}
