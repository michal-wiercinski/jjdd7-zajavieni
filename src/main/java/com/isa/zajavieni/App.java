package com.isa.zajavieni;

import com.isa.zajavieni.menu.MainMenu;
import com.isa.zajavieni.service.DataParseService;

import java.io.IOException;
import java.text.ParseException;

public class App {

    public static void main(String[] args) throws IOException, ParseException {
        DataParseService parseService = new DataParseService();
        parseService.parseEvents("events.json");
        new MainMenu().mainMenu();
    }
}
