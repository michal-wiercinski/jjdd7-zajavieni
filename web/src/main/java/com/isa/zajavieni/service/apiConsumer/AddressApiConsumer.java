package com.isa.zajavieni.service.apiConsumer;

import com.isa.zajavieni.web.servlet.LoggerServlet;
import java.io.IOException;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class AddressApiConsumer {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());
  private WebTarget webTargetAddress;
  private static final String URI_ADDRESS = "http://isa-proxy.blueazurit.com/gdansk-events/places.json";

  public String consumeAddress() throws IOException {
    initAddress();
    logger.info("ApiAddress response prepared");
    Response response = webTargetAddress.request().get();
    String resp = response.readEntity(String.class);
    return resp;
  }

  private void initAddress() {
    logger.info("ApiAdress consumer started");
    Client client = ClientBuilder.newClient();
    webTargetAddress = client.target(URI_ADDRESS);
  }
}
