package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Organizer;
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
public class OrganizerApiConsumer {
  private WebTarget webTargetOrganizer;
  private static final String URIorganizer = "http://isa-proxy.blueazurit.com/gdansk-events/organizers.json";

  @Inject
  private DataParseService dataParseService;

  public List<Organizer> consumeOrganizer () throws IOException {
    initOrganizer();
    Response response = webTargetOrganizer.request().get();
    String resp = response.readEntity(String.class);

    return dataParseService.parseOrganizersFromApi(resp);
  }

  private void initOrganizer() {
    Client client = ClientBuilder.newClient();
    webTargetOrganizer = client.target(URIorganizer);
  }

}
