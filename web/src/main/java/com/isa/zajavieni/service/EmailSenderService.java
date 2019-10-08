package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.BookingDaoBean;
import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.web.servlet.LoggerServlet;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
  private static final String deleteContent = "Drogi użytkowniku,<br><br>"
      + "Z przykrością informujemy, że wydarzenie należące do ulubionych '%s' zostało usunięte z serwisu przez administratora.<br><br>"
      + "Administratorzy serwisu 3cityevent";
  private static final String timedContent = "Drogi użytkowniku,<br><br>"
      + "Uprzejmie informujemy, że wydarzenie należące do ulubionych '%s' straciło ważność i zostało usunięte z ulubionych.<br><br>"
      + "Administratorzy serwisu 3cityevent";
  private static final String bookingContent = "Drogi użytkowniku, <br><br>"
      + "Dokonałeś rezerwacji na wydarzenie %s.<br><br>"
      + "Administratorzy serwisu 3cityevent";
  private static final String cancelBookingContent = "Drogi użytkowniku, <br><br>"
      + "Odwołałeś rezerwację na wydarzenie %s.<br><br>"
      + "Administratorzy serwisu 3cityevent";
  private static final String deleteEventBookedContent = "Drogi użytkowniku,<br><br>"
      + "Z przykrością informujemy, że wydarzenie '%s' które zarezerwowałeś zostało usunięte z serwisu przez administratora.<br><br>"
      + "Administratorzy serwisu 3cityevent";

  @EJB
  private UserDaoBean userDaoBean;

  @EJB
  private EventsDaoBean eventsDaoBean;

  @EJB
  private BookingDaoBean bookingDaoBean;

  @EJB
  private PropertiesLoaderService propertiesLoaderService;

  public void sendDeletedEventEmailForUsers(Long id) {
    List<User> userList = userDaoBean.findUsersWithFavouriteEvents(id);
    userList.forEach(user -> {
      try {
        sendDeletedEventEmail(user.getEmail(), id);
      } catch (MessagingException | IOException e) {
        logger.error(e.getMessage());
      }
    });
  }

  public void sendTimedEventEmailForUsers(Long id) {
    List<User> userList = userDaoBean.findUsersWithFavouriteEvents(id);
    userList.forEach(user -> {
      try {
        sendTimedEventEmail(user.getEmail(), id);
      } catch (MessagingException | IOException e) {
        logger.error(e.getMessage());
      }
    });
  }

  public void sendBookingEmailForUser(Long userId, Long eventId) {
    User user = userDaoBean.findById(userId);
    try {
      sendBookingEmail(user.getEmail(), eventId);
    } catch (MessagingException | IOException e) {
      logger.error(e.getMessage());
    }
  }

  public void sendCancelingBookingEmailForUser(Long userId, Long eventId) {
    User user = userDaoBean.findById(userId);
    try {
      sendCancelingBookingEmail(user.getEmail(), eventId);
    } catch (MessagingException | IOException e) {
      logger.error(e.getMessage());
    }
  }

  public void sendDeletedBookedEventForUser(Long eventId){
    List<Long> usersId = bookingDaoBean.getUserWithBookedEvent(eventId);
    usersId.forEach(uId -> {
      User user = userDaoBean.findById(uId);
      try {
        sendDeletedBookedEventEmail(user.getEmail(), eventId);
      } catch (MessagingException | IOException e) {
        logger.error(e.getMessage());
      }
    });
  }

  private void sendDeletedEventEmail(String email, Long eventId)
      throws MessagingException, IOException {
    String to = email;
    Event timedEvent = eventsDaoBean.findById(eventId);
    String subject = "3cityevent | Zmiana w Twoich ulubionych wydarzeniach";
    String content = String.format(deleteContent, timedEvent.getName());
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

  private void sendTimedEventEmail(String email, Long eventId)
      throws MessagingException, IOException {
    String to = email;
    Event timedEvent = eventsDaoBean.findById(eventId);
    String subject = "3cityevent | Zmiana w Twoich ulubionych wydarzeniach";
    String content = String.format(timedContent, timedEvent.getName());
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

  private void sendBookingEmail(String email, Long eventId)
      throws MessagingException, IOException {
    String to = email;
    Event timedEvent = eventsDaoBean.findById(eventId);
    String subject = "3cityevent | Potwierdzenie rezerwacji";
    String content = String.format(bookingContent, timedEvent.getName());
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

  private void sendCancelingBookingEmail(String email, Long eventId)
      throws MessagingException, IOException {
    String to = email;
    Event timedEvent = eventsDaoBean.findById(eventId);
    String subject = "3cityevent | Anulowanie rezerwacji";
    String content = String.format(cancelBookingContent, timedEvent.getName());
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
   private void sendDeletedBookedEventEmail(String email, Long eventId)
      throws MessagingException, IOException {
    String to = email;
    Event timedEvent = eventsDaoBean.findById(eventId);
    String subject = "3cityevent | Odwołano zarezerwowane wydarzenie";
    String content = String.format(deleteEventBookedContent, timedEvent.getName());
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