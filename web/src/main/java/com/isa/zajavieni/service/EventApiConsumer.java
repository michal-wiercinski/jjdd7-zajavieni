package com.isa.zajavieni.service;

import java.io.IOException;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class EventApiConsumer {

  private WebTarget webTargetEvent;
  private static final String URIevent = "http://isa-proxy.blueazurit.com/gdansk-events/events.json?";

  public String consumeEvent() throws IOException {
    initEvent();
    Response response = webTargetEvent.request().get();
    String resp = response.readEntity(String.class);
    return resp;
  }

  private void initEvent() {
    Client client = ClientBuilder.newClient();
    webTargetEvent = client.target(URIevent);
  }
}
