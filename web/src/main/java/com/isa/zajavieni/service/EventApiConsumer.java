package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.mapper.EventsMapper;
import com.isa.zajavieni.parser.DataParseService;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class EventApiConsumer {
  private WebTarget webTarget;
  private static final String URI = "http://isa-proxy.blueazurit.com/gdansk-events/events.json";

  @Inject
  private DataParseService dataParseService;

  @Inject
  private EventsMapper eventsMapper;

  @Inject
  private EventsDaoBean eventsDaoBean;

  public List<Event> consume() throws IOException {
    init();
    Response response = webTarget.request().get();
    String resp = response.readEntity(String.class);

    return dataParseService.parseEvents(resp);
  }

  private void init() {
    Client client = ClientBuilder.newClient();
    webTarget = client.target(URI);
  }

  public void loadDataToDataBase() {
    try {
      List<com.isa.zajavieni.Entity.Event> events = eventsMapper.mapEventsApiToEntity(consume());
      events.forEach(event -> eventsDaoBean.saveEvent(event));
    } catch (IOException e) {

    }
  }



}
