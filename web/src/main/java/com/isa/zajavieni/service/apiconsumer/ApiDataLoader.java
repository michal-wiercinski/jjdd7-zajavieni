package com.isa.zajavieni.service.apiconsumer;

import com.isa.zajavieni.dao.AddressDaoBean;
import com.isa.zajavieni.dao.CategoriesDaoBean;
import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dao.OrganizersDaoBean;
import com.isa.zajavieni.entity.fromapi.Address;
import com.isa.zajavieni.jsonclasses.Category;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.jsonclasses.Place;
import com.isa.zajavieni.mapper.entitymapper.AddressMapper;
import com.isa.zajavieni.mapper.entitymapper.CategoryMapper;
import com.isa.zajavieni.mapper.entitymapper.EventsMapper;
import com.isa.zajavieni.mapper.entitymapper.OrganizersMapper;
import com.isa.zajavieni.parser.DataParseService;
import com.isa.zajavieni.web.servlet.LoggerServlet;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class ApiDataLoader {

  private Logger logger = LoggerFactory.getLogger(LoggerServlet.class.getName());
  @Inject
  private DataParseService dataParseService;

  @EJB
  private EventsMapper eventsMapper;

  @EJB
  private AddressMapper addressMapper;

  @EJB
  private CategoryMapper categoryMapper;

  @EJB
  private OrganizersMapper organizersMapper;

  @EJB
  private CategoryApiConsumer categoryApiConsumer;

  @EJB
  private CategoriesDaoBean categoriesDaoBean;

  @EJB
  private AddressApiConsumer addressApiConsumer;

  @EJB
  private AddressDaoBean addressDaoBean;

  @EJB
  private OrganizerApiConsumer organizerApiConsumer;

  @EJB
  private OrganizersDaoBean organizersDaoBean;

  @EJB
  private EventApiConsumer eventApiConsumer;

  @EJB
  private EventsDaoBean eventsDaoBean;

  public void loadDataToDataBaseCategory() {
    try {
      logger.info("Load categories to DB");
      List<Category> categoryList = dataParseService
          .parseCategories(categoryApiConsumer.consumeCategory());
      categoryList.forEach(category -> {
        com.isa.zajavieni.entity.fromapi.Category categoryEntity = categoryMapper
            .mapCategoriesApiToEntity(category);
        categoriesDaoBean.editCategory(categoryEntity);
      });
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }

  public void loadDataToDataBaseAddress() {
    try {
      logger.info("Load addresses to DB");
      List<Place> addressList = dataParseService
          .parsePlaces(addressApiConsumer.consumeAddress());
      addressList.forEach(address -> {
        Address addressEntity = addressMapper
            .mapAddressApiToEntity(address);
        addressDaoBean.savePlace(addressEntity);
      });
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }

  public void loadDataToDataBaseOrganizer() {
    try {
      logger.info("Load organizers to DB");
      List<Organizer> organizerList = dataParseService
          .parseOrganizers(organizerApiConsumer.consumeOrganizer());
      organizerList.forEach(organizer -> {
        com.isa.zajavieni.entity.fromapi.Organizer organizerEntity = organizersMapper
            .mapOrganizersApiToEntity(organizer);
        organizersDaoBean.saveOrganizer(organizerEntity);
      });
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }

  public void loadDataToDataBaseEvent() {
    try {
      logger.info("Load events to DB");
      List<Event> eventsList = dataParseService.parseEvents(eventApiConsumer.consumeEvent());
      eventsList.forEach(event -> {
        com.isa.zajavieni.entity.fromapi.Event eventEntity = eventsMapper.mapEventsApiToEntity(event);
        eventsDaoBean.editEvent(eventEntity);
      });
    } catch (IOException e) {
      logger.error(e.getMessage());
    }
  }
}
