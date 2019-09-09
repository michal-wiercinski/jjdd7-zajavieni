package com.isa.zajavieni.service;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class EventsApiInitializer {

  @Inject
  private EventApiConsumer eventApiConsumer;

  @PostConstruct
  protected void init() {
    try {
      eventApiConsumer.consume();
      eventApiConsumer.loadDataToDataBase();
    } catch (IOException e) {
    }
  }
}
