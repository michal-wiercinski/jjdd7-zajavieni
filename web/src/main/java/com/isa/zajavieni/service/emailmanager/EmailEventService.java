package com.isa.zajavieni.service.emailmanager;

import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.servlet.LoggerServlet;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EmailEventService {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @EJB
  private EmailSenderService emailSenderService;

  private static final String RECIPIENT = "zajavieni7@gmail.com";

  public void buildEmailMessage(Event event, User user){
    String subject = "Zmiana w Twoich ulubionych wydarzeniach";

    String emailContent = String.format("Drogi użytkowniku,<br><br>"
        + "Z przykrością informujemy, że jedno z Twoich wydarzeń zostało usunięte z serwisu.<br><br>"
        + "Administratorzy serwisu 3cityevent", event.getName());

    try {
      logger.info("Email to user id: {} was sent to boss", user.getId());
      emailSenderService.sendMessage(RECIPIENT, emailContent, subject);
    } catch (MessagingException e) {
      logger.error(e.getMessage());
    }
  }
}
