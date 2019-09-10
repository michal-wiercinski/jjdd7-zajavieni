package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Place;
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
public class AddressApiConsumer {
  private WebTarget webTargetAddress;
  private static final String URIaddress= "http://isa-proxy.blueazurit.com/gdansk-events/places.json";

  @Inject
  private DataParseService dataParseService;

  public List<Place> consumeAddress () throws IOException {
    initAddress();
    Response response = webTargetAddress.request().get();
    String resp = response.readEntity(String.class);

    return dataParseService.parsePlacesFromApi(resp);
  }

  private void initAddress() {
    Client client = ClientBuilder.newClient();
    webTargetAddress = client.target(URIaddress);
  }
}
