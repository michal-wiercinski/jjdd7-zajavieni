package com.isa.zajavieni.service;

import com.isa.zajavieni.servlet.LoggerServlet;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EventApiConsumer {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());
  private static final String URIevent = "http://isa-proxy.blueazurit.com/gdansk-events/events.json?";

  public String consumeEvent() throws IOException {
    List<String> eventList = new ArrayList<>();
    LocalDate today = LocalDate.now();
    LocalDate startDate = today;
    int intervalTime = 4;
    int numberOfPeriods = 8;
    LocalDate endDate = today.plusDays(intervalTime);
    for (int i = 0; i < numberOfPeriods; i++) {
      logger.info("ApiEvent consumer started");
      Client client = ClientBuilder.newClient();
      WebTarget webTargetEvent = client.target(
          URIevent + "start_date=" + startDate.toString() + "&end_date=" + endDate.toString());
      startDate = startDate.plusDays(intervalTime);
      endDate = endDate.plusDays(intervalTime);
      logger.info("ApiEvent response prepared");
      Response response = webTargetEvent.request().get();
      String resp = response.readEntity(String.class);
      eventList.add(resp);
    }
    return eventList.stream().collect(Collectors.joining()).replaceAll("]\\[", ",");
  }
}
