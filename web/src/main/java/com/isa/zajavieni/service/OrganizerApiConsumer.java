package com.isa.zajavieni.service;

import java.io.IOException;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class OrganizerApiConsumer {

  private WebTarget webTargetOrganizer;
  private static final String URIorganizer = "http://isa-proxy.blueazurit.com/gdansk-events/organizers.json";

  public String consumeOrganizer() throws IOException {
    initOrganizer();
    Response response = webTargetOrganizer.request().get();
    String resp = response.readEntity(String.class);
    return resp;
  }

  private void initOrganizer() {
    Client client = ClientBuilder.newClient();
    webTargetOrganizer = client.target(URIorganizer);
  }

}
