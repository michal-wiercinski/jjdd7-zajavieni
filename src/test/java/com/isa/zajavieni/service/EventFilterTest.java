package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Event;
import com.isa.zajavieni.repository.EventList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EventFilterTest {
  private Date startDate;
  private Date endDate;
  private List<String> listOrganizers = new ArrayList<>();

  @Test
  void filterEventsList_testIfPrintCorrectEvent() {
    EventFilter eventFilter  = new EventFilter();
    startDate = new Date(2019,8,20);
    endDate =new Date(2019,8,26 );
    listOrganizers.add("instytutkulturymiejskiej");

    List<Event> list = eventFilter.filterEventsList(EventList.getEventList(),startDate, endDate,listOrganizers);

    assertEquals("Zwiedzaj Stoczni\\u0119 Gda\\u0144sk\\u0105 szlakami kobiet \\u2717 Metropolitanka",
        list.stream().map(Event::getName).findFirst().get());
  }
}