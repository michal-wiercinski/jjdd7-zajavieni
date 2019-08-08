package com.infoshareacademy;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JsonToObject {


/*    public <T> Object convertToObject(String filePathName, Class<T> targetClass) {
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
    }*/


    /*public List<Class> convertToObject(String filePathName, Class targetClass){

        ObjectMapper mapper = new ObjectMapper();



    }*/
    public List<Event> convertToEventsList()throws IOException {
        List<Event> eventsList = new ArrayList<>();
        try {
            File file = new File(Objects.requireNonNull(JsonToObject.class.getClassLoader().getResource("events.json")).getFile());

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
            objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
            eventsList = objectMapper.readValue(file, new TypeReference<List<Event>>() {
            });
        } catch (JsonGenerationException | JsonMappingException | JsonParseException | NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println(eventsList);
            return eventsList;
    }
}
