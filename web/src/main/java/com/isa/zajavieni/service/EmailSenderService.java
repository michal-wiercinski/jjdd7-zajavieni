package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.servlet.LoggerServlet;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EmailSenderService {

  private static final String mailTransportProtocol = "smtp";
  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @Inject
  private UserDaoBean userDaoBean;

  @EJB
  private PropertiesLoaderService propertiesLoaderService;

  public void sendEmailForAllUsers(Long id) {
    List<User> userList = userDaoBean.findUsersWithFavouriteEvents(id);
    userList.forEach(user -> {
      try {
        sendEmail(user.getEmail());
      } catch (MessagingException | IOException e) {
        logger.error(e.getMessage());
      }
    });
  }

  public void sendEmail(String email) throws MessagingException, IOException {
    String to = email;
    String subject = "Zmiana w Twoich ulubionych wydarzeniach";
    String content = "Drogi użytkowniku,<br><br>"
        + "Z przykrością informujemy, że jedno z Twoich wydarzeń zostało usunięte z serwisu przez administratora.<br><br>"
        + "Administratorzy serwisu 3cityevent";
    Session session = Session
        .getDefaultInstance(propertiesLoaderService.loadMailProperties(), null);
    MimeMessage message = new MimeMessage(session);
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    message.setSubject(subject);
    message.setContent(content, "text/html; charset=utf-8");
    Transport transport = session.getTransport(mailTransportProtocol);
    String username = propertiesLoaderService.loadCredentialsProperties()
        .getProperty("user.name");
    String password = propertiesLoaderService.loadCredentialsProperties()
        .getProperty("user.password");
    String server = propertiesLoaderService.loadServerProperties().getProperty("mail.smtp.host");
    transport.connect(server, username, password);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  }
}
