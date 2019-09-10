package com.isa.zajavieni.service;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class ApiInitializer {

  @EJB
  private LoadDataToDateBase loadDataToDataBase;

  @PostConstruct
  protected void init() {
    loadDataToDataBase.loadDataToDataBaseCategory();
    loadDataToDataBase.loadDataToDataBaseAddress();
    loadDataToDataBase.loadDataToDataBaseOrganizer();
    loadDataToDataBase.loadDataToDataBaseEvent();
  }
}
