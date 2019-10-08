package com.isa.zajavieni.service.jsonservice;

import com.isa.zajavieni.jsonresponse.EventResponse;
import com.isa.zajavieni.mapper.jsonmapper.EventJsonMapper;
import com.isa.zajavieni.service.dtoservice.EventDtoService;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

@Stateless
public class EventResponseService {

  @EJB
  EventJsonMapper eventJsonMapper;

  @EJB
  EventDtoService eventDtoService;

  @Transactional
  public EventResponse getEventJsonById(Long id){
    return eventJsonMapper.mapDtoToJson(eventDtoService.findById(id));
  }
}
