package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.entity.Event;
import com.isa.zajavieni.servlet.LoggerServlet;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EventService {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @Inject
  EventsDaoBean eventsDaoBean;

  public Event findEventById(Long id) {
    logger.info("Find event id: {}", id);
    Event event = eventsDaoBean.findEventById(id);
    return event;
  }

}
