package com.isa.zajavieni.service;

import com.isa.zajavieni.dao.EventsDaoBean;
import com.isa.zajavieni.entity.Event;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class SearchService {

    @EJB
    private EventsDaoBean eventsDaoBean;

    public List<Event> searchEvents(String phrase){
        return eventsDaoBean.searchEvents(phrase);
    }
}
