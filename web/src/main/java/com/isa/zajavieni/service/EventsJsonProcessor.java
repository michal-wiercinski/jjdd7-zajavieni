package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.mapper.EventsMapper;
import com.isa.zajavieni.parser.DataParseService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

/*@Stateless
public class EventsJsonProcessor {

    @EJB
    private DataParseService dataParseService;

    @EJB
    private EventsMapper eventsMapper;

    @EJB
    private EventsDaoBean eventsDaoBean;

    public void processEventsJson(String eventsJson) throws IOException {
        List<Event> events = dataParseService.parseEvents(eventsJson);
        for (Event event : events) {
            com.isa.zajavieni.entity.Event mapEventToEntity = eventsMapper.mapEventsApiToEntity(event);
            eventsDaoBean.saveEvent(mapEventToEntity);
        }
    }


}*/
