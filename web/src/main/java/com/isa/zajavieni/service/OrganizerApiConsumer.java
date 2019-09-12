package com.isa.zajavieni.service;

import com.isa.zajavieni.servlet.LoggerServlet;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class OrganizerApiConsumer {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());
  private WebTarget webTargetOrganizer;
  private static final String URIorganizer = "http://isa-proxy.blueazurit.com/gdansk-events/organizers.json";

  public String consumeOrganizer() throws IOException {
    initOrganizer();
    logger.info("ApiOrganizer response prepared");
    Response response = webTargetOrganizer.request().get();
    String resp = response.readEntity(String.class);
    return resp;
  }

  private void initOrganizer() {
    logger.info("ApiOrganizer consumer started");
    Client client = ClientBuilder.newClient();
    webTargetOrganizer = client.target(URIorganizer);
  }
}
