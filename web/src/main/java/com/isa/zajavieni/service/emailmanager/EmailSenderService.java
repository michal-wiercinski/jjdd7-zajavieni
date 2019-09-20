package com.isa.zajavieni.service.emailmanager;

import com.isa.zajavieni.servlet.LoggerServlet;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class EmailSenderService<PropertiesLoaderService> {

  private static final String MAIL_TRANSPORT_PROTOCOL = "smtp";
  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());

  @EJB
  private PropertiesLoaderService propertiesLoaderService;

}
