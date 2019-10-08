package com.isa.zajavieni.web.oauth;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import javax.ejb.Stateless;

@Stateless
public class OauthBuilder {

  public Oauth2 buildOauth(Credential credential) {

    GoogleCredential gCredential = new GoogleCredential()
        .setAccessToken(credential.getAccessToken());

    Oauth2 oauth2 = new Oauth2.Builder(
        new NetHttpTransport(),
        JacksonFactory.getDefaultInstance(),
        gCredential)
        .setApplicationName("3cityevent")
        .build();

    return oauth2;
  }
}
