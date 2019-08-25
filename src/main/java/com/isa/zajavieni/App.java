package com.isa.zajavieni;

import com.isa.zajavieni.menu.MainMenu;

import com.isa.zajavieni.repository.EventList;
import com.isa.zajavieni.repository.FavouriteEventList;
import com.isa.zajavieni.service.DataParseService;
import java.io.IOException;
import java.text.ParseException;

public class App {

    public static void main(String[] args) throws IOException, ParseException {
        DataParseService parseService = new DataParseService();
        EventList.getEventList().addAll(parseService.parseEvents(EventList.getEventsJson()));
        FavouriteEventList.getFavouriteEventList().addAll(parseService.parseEvents(FavouriteEventList.getFavouriteEventsJson()));
        new MainMenu().mainMenu();
        }
    }
