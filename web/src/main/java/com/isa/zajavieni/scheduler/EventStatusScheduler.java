package com.isa.zajavieni.scheduler;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dao.UserDaoBean;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.entity.User;
import com.isa.zajavieni.service.EmailSenderService;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class EventStatusScheduler {

  @EJB
  EventsDaoBean eventsDaoBean;

  @EJB
  UserDaoBean userDaoBean;

  @EJB
  EmailSenderService emailSenderService;

  @Schedule(hour = "*", minute = "*/1", info = "Every 1 minute timer")
  public void checkStatusOfEvents() {
    LocalDateTime now = LocalDateTime.now();

    List<Event> favouriteEvents = eventsDaoBean.findAllFavouriteEvents();

    for (Event event : favouriteEvents) {
      if (event.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
          .compareTo(now) < 0) {
        List<User> users = userDaoBean.findUsersWithFavouriteEvents(event.getId());
        emailSenderService.sendTimedEventEmailForUsers(event.getId());
        users.forEach(u -> u.getEvents().remove(event));
        users.forEach(u -> userDaoBean.updateUser(u));
        eventsDaoBean.editEvent(event);
      }
    }
  }
}
