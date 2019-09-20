package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.entity.User;
import java.util.List;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class SendEmailService {

  @Inject
  private UserDaoBean userDaoBean;

  public void sendEmailForAllUsers(Long id){
    List<User> userList = userDaoBean.findUsersWithFavouriteEvents(id);
    userList.forEach(user -> sendEmail(user.getEmail()));
  }

  public void sendEmail(String email){
  String to = email;
  String from = "zajavieni7@gmail.com";
  String host = "smtp.gmail.com";
  Properties properties = System.getProperties();
  properties.put("mail.smtp.port", "587");
  properties.put("mail.smtp.auth", "true");
  properties.put("mail.smtp.starttls.enable", "true");
  Session session = Session.getDefaultInstance(properties, null);
  try {
    MimeMessage message = new MimeMessage(session);
    message.addRecipient(Message.RecipientType.CC, new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    message.setSubject("Zmiana w Twoich ulubionych wydarzeniach");
    message.setContent("Drogi użytkowniku,<br><br>"
        + "Z przykrością informujemy, że jedno z Twoich wydarzeń zostało usunięte z serwisu przez administratora.<br><br>"
        +  "Administratorzy serwisu 3cityevent\"", "text/html");
    Transport transport = session.getTransport("smtp");
    transport.connect("smtp.gmail.com", "zajavieni7@gmail.com", "adminisA!1");
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  } catch (MessagingException mex) {
    mex.printStackTrace();
  }
}

}
