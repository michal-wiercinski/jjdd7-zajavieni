package com.isa.zajavieni.oauth;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class GoogleLoginCommons {

  private static final String CLIENT_FILE = "google.properties";
  private static final String REDIRECT_URL = "/oauth2callback";
  private static final List<String> SCOPES = List.of("openid", "email", "profile");


  static String buildRedirectUri(HttpServletRequest req) {
    GenericUrl url = new GenericUrl(req.getRequestURL().toString());
    url.setRawPath(REDIRECT_URL);
    return url.build();
  }

  static GoogleAuthorizationCodeFlow buildFlow() throws IOException {
    GoogleAuthorizationCodeFlow online = new GoogleAuthorizationCodeFlow.Builder(
        new NetHttpTransport(),
        JacksonFactory.getDefaultInstance(), getClientID(),
        getClientSecret(), SCOPES)
        .setAccessType("online")
        .build();
    return online;
  }


  private static String getClientID() throws IOException {
    Properties settings = new Properties();
    settings.load(Objects.requireNonNull(Thread.currentThread()
        .getContextClassLoader().getResource(CLIENT_FILE))
        .openStream());
    return settings.getProperty("client.id");
  }

  private static String getClientSecret() throws IOException {
    Properties settings = new Properties();
    settings.load(Objects.requireNonNull(Thread.currentThread()
        .getContextClassLoader().getResource(CLIENT_FILE))
        .openStream());
    return settings.getProperty("client.secret");
  }

}
