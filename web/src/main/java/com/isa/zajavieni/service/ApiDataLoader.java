package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.AddressDaoBean;
import com.isa.zajavieni.dao.CategoriesDaoBean;
import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.dao.OrganizersDaoBean;
import com.isa.zajavieni.jsonclasses.Category;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.jsonclasses.Place;
import com.isa.zajavieni.mapper.AddressMapper;
import com.isa.zajavieni.mapper.CategoryMapper;
import com.isa.zajavieni.mapper.EventsMapper;
import com.isa.zajavieni.mapper.OrganizersMapper;
import com.isa.zajavieni.parser.DataParseService;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ApiDataLoader {

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
      List<Category> categoryList = dataParseService.parseCategoriesFromApi(categoryApiConsumer.consumeCategory());
      categoryList.forEach(category -> {
        com.isa.zajavieni.entity.Category categoryEntity = categoryMapper
            .mapCategoriesApiToEntity(category);
        categoriesDaoBean.editCategory(categoryEntity);
      });
    } catch (IOException e) {
    }
  }

  public void loadDataToDataBaseAddress() {
    try {
      List<Place> addressList = dataParseService.parsePlacesFromApi(addressApiConsumer.consumeAddress());
      addressList.forEach(address -> {
        com.isa.zajavieni.entity.Address addressEntity = addressMapper
            .mapAddressApiToEntity(address);
        addressDaoBean.savePlace(addressEntity);
      });
    } catch (IOException e) {
    }
  }

  public void loadDataToDataBaseOrganizer() {
    try {
      List<Organizer> organizerList = dataParseService.parseOrganizersFromApi(organizerApiConsumer.consumeOrganizer());
      organizerList.forEach(organizer -> {
        com.isa.zajavieni.entity.Organizer organizerEntity = organizersMapper
            .mapOrganizersApiToEntity(organizer);
        organizersDaoBean.saveOrganizer(organizerEntity);
      });
    } catch (IOException e) {
    }
  }

  public void loadDataToDataBaseEvent() {
    try {
      List<Event> eventsList = dataParseService.parseEventsFromApi(eventApiConsumer.consumeEvent());
      eventsList.forEach(event -> {
        com.isa.zajavieni.entity.Event eventEntity = eventsMapper.mapEventsApiToEntity(event);
        eventsDaoBean.saveEvent(eventEntity);
      });
    } catch (IOException e) {
    }
  }
}
