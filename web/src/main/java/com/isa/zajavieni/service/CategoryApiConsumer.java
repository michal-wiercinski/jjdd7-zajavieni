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
public class CategoryApiConsumer {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());
  private WebTarget webTargetCategory;
  private static final String URIcategory = "http://isa-proxy.blueazurit.com/gdansk-events/categories.json";

  public String consumeCategory() throws IOException {
    initCategory();
    logger.info("ApiCategory response prepared");
    Response response = webTargetCategory.request().get();
    String resp = response.readEntity(String.class);
    return resp;
  }

  private void initCategory() {
    logger.info("ApiCategory consumer started");
    Client client = ClientBuilder.newClient();
    webTargetCategory = client.target(URIcategory);
  }
}
