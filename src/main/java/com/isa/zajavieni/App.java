package com.isa.zajavieni;


import com.isa.zajavieni.jsonclasses.Event;

import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.menu.MainMenu;

import com.isa.zajavieni.repository.EventList;
import com.isa.zajavieni.repository.OrganizerList;
import com.isa.zajavieni.service.DataParseService;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        DataParseService parseService = new DataParseService();
        EventList.getEventList().addAll(parseService.parseEvents("events.json"));
        OrganizerList.getOrganizerList().addAll(parseService.parseOrganizers("organizers.json"));
        new MainMenu().mainMenu();
    }
}