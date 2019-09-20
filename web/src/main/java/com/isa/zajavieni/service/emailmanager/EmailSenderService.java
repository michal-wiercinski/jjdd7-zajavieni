package com.isa.zajavieni.service.emailmanager;

import com.isa.zajavieni.service.propertiesmanager.PropertiesLoaderService;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EmailSenderService {

  private static final String MAIL_TRANSPORT_PROTOCOL = "smtp";
  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @EJB
  private PropertiesLoaderService propertiesLoaderService;

  public void sendMessage(String recipient, String emailContent, String subject)
      throws MessagingException {

    try {
      Session getMailSession = Session
          .getDefaultInstance(propertiesLoaderService.loadMailProperties(), null);

      MimeMessage generateMailMessage = new MimeMessage(getMailSession);
      generateMailMessage.addRecipient(RecipientType.TO, new InternetAddress(recipient));
      generateMailMessage.setSubject(subject);
      generateMailMessage.setContent(emailContent, "text/html");

      Transport transport = getMailSession.getTransport(MAIL_TRANSPORT_PROTOCOL);

      String username = propertiesLoaderService.loadCredentialsProperties()
          .getProperty("user.name");
      String password = propertiesLoaderService.loadCredentialsProperties()
          .getProperty("user.password");
      String server = propertiesLoaderService.loadServerProperties().getProperty("mail.smtp.host");

      logger.info("Email send to {}", username);
      transport.connect(server, username, password);
      transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
      transport.close();
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
    }

}
