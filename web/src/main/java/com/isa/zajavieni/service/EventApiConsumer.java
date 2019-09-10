package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
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
  private WebTarget webTargetEvent;
  private static final String URIevent = "http://isa-proxy.blueazurit.com/gdansk-events/events.json";

  @Inject
  private DataParseService dataParseService;

  public List<Event> consumeEvent () throws IOException {
    initEvent();
    Response response = webTargetEvent.request().get();
    String resp = response.readEntity(String.class);

    return dataParseService.parseEventsFromApi(resp);
  }

    /*
    List<Event> eventlist = new ArrayList();
      while (data < today + 7 days){
        String uri=URIEVENT + "?startDate=data"

        initEvent();
        Response response = webTargetEvent.request().get();
        String resp = response.readEntity(String.class);
        eventlist.addAll(dataParseService.parseEventsFromApi(resp))
      }
     */

    //return eventList;


  private void initEvent() {
    Client client = ClientBuilder.newClient();
    webTargetEvent = client.target(URIevent);
  }
}
