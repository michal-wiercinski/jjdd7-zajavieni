package com.isa.zajavieni.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.zajavieni.dto.EventDto;
import com.isa.zajavieni.jsonclasses.Category;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.jsonclasses.Place;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class DataParseService {

  private ObjectMapper objectMapper = new ObjectMapper();
  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  public List<Event> parseEvents(String events) throws IOException {
    logger.info("Parse events");
    JsonNode jsonNode = objectMapper.readTree(events);
    return objectMapper.readValue(jsonNode.toString(),
        new TypeReference<List<Event>>() {
        });
  }

  public List<Category> parseCategories(String categories) throws IOException {
    logger.info("Parse categories");
    JsonNode jsonNode = objectMapper.readTree(categories);
    return objectMapper.readValue(jsonNode.toString(),
        new TypeReference<List<Category>>() {
        });
  }

  public List<Place> parsePlaces(String places) throws IOException {
    logger.info("Parse address");
    JsonNode jsonNode = objectMapper.readTree(places);
    return objectMapper.readValue(jsonNode.toString(),
        new TypeReference<List<Place>>() {
        });
  }

  public List<Organizer> parseOrganizers(String organizers) throws IOException {
    logger.info("Parse organizers");
    JsonNode jsonNode = objectMapper.readTree(organizers);
    return objectMapper.readValue(jsonNode.toString(),
        new TypeReference<List<Organizer>>() {
        });
  }

  public Event serialzeEvents(EventDto event) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(event);
    return
  }
}