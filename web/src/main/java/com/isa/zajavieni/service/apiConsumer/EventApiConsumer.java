package com.isa.zajavieni.service.apiConsumer;

import com.isa.zajavieni.web.servlet.LoggerServlet;
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
  private static final String URI_EVENT = "http://isa-proxy.blueazurit.com/gdansk-events/events.json?";

  public String consumeEvent() throws IOException {
    List<String> eventList = new ArrayList<>();
    LocalDate today = LocalDate.now();
    LocalDate startDate = today;
    int intervalTime = 4;
//przestawione na 1 , żeby długo nie czekać. Eventy przychodzą 1 raz z 4 dni. Na developie jest 8.
//    int numberOfPeriods = 8;
    int numberOfPeriods = 1;
    LocalDate endDate = today.plusDays(intervalTime);
    for (int i = 0; i < numberOfPeriods; i++) {
      logger.info("ApiEvent consumer started");
      Client client = ClientBuilder.newClient();
      WebTarget webTargetEvent = client
          .target(String.format("%sstart_date=%s&end_date=%s", URI_EVENT, startDate.toString(),
              endDate.toString()));
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
