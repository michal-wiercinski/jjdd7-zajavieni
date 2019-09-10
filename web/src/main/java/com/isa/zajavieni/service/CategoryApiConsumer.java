package com.isa.zajavieni.service;

import java.io.IOException;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class CategoryApiConsumer {

  private WebTarget webTargetCategory;
  private static final String URIcategory = "http://isa-proxy.blueazurit.com/gdansk-events/categories.json";

  public String consumeCategory() throws IOException {
    initCategory();
    Response response = webTargetCategory.request().get();
    String resp = response.readEntity(String.class);
    return resp;
  }

  private void initCategory() {
    Client client = ClientBuilder.newClient();
    webTargetCategory = client.target(URIcategory);
  }
}
