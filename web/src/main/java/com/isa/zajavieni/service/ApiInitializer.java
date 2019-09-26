package com.isa.zajavieni.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ApiInitializer {

  @EJB
  private ApiDataLoader apiDataLoader;

  @PostConstruct
  protected void init() {
    //apiDataLoader.loadDataToDataBaseCategory();
    apiDataLoader.loadDataToDataBaseAddress();
    apiDataLoader.loadDataToDataBaseOrganizer();
    apiDataLoader.loadDataToDataBaseEvent();
  }
}
