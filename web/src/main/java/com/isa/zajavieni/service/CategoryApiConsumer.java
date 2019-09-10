package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Category;
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
public class CategoryApiConsumer {
  private WebTarget webTargetCategory;
  private static final String URIcategory = "http://isa-proxy.blueazurit.com/gdansk-events/categories.json";

  @Inject
  private DataParseService dataParseService;

  public List<Category> consumeCategory () throws IOException {
    initCategory();
    Response response = webTargetCategory.request().get();
    String resp = response.readEntity(String.class);

    return dataParseService.parseCategoriesFromApi(resp);
  }

  private void initCategory() {
    Client client = ClientBuilder.newClient();
    webTargetCategory = client.target(URIcategory);
  }

}
