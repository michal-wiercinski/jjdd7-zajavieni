package com.isa.zajavieni.service;

import java.io.IOException;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateless
public class AddressApiConsumer {

  private WebTarget webTargetAddress;
  private static final String URIaddress = "http://isa-proxy.blueazurit.com/gdansk-events/places.json";

  public String consumeAddress() throws IOException {
    initAddress();
    Response response = webTargetAddress.request().get();
    String resp = response.readEntity(String.class);
    return resp;
  }

  private void initAddress() {
    Client client = ClientBuilder.newClient();
    webTargetAddress = client.target(URIaddress);
  }
}
