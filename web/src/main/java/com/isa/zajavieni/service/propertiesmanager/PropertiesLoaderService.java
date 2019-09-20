package com.isa.zajavieni.service.propertiesmanager;

import com.isa.zajavieni.servlet.LoggerServlet;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class PropertiesLoaderService {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());
  private static final String SENDMAIL_PROPERTIES = "sendmail.properties";
  private static final String CREDENTIALS_PROPERTIES = "credentials.properties";
  private static final String SERVER_PROPERTIES = "servermail.properties";

  public Properties loadMailProperties() throws IOException {

    Properties mailProperties = new Properties();
    mailProperties.load(Objects.requireNonNull(Thread.currentThread()
        .getContextClassLoader().getResource(SENDMAIL_PROPERTIES))
        .openStream());
    logger.info("Load {}", SENDMAIL_PROPERTIES);
    return mailProperties;
  }

  public Properties loadCredentialsProperties() throws IOException {

    Properties credentialsProperties = new Properties();
    credentialsProperties.load(Objects.requireNonNull(Thread.currentThread()
        .getContextClassLoader().getResource(CREDENTIALS_PROPERTIES))
        .openStream());
    logger.info("Load {}", CREDENTIALS_PROPERTIES);
    return credentialsProperties;
  }

  public Properties loadServerProperties() throws IOException {

    Properties serverProperties = new Properties();
    serverProperties.load(Objects.requireNonNull(Thread.currentThread()
        .getContextClassLoader().getResource(SERVER_PROPERTIES))
        .openStream());
    logger.info("Load {}", SERVER_PROPERTIES);
    return serverProperties;
  }

}
