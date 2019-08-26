package com.isa.zajavieni;

import com.isa.zajavieni.menu.MainMenu;
import com.isa.zajavieni.repository.CategoryList;
import com.isa.zajavieni.repository.EventList;
import com.isa.zajavieni.repository.OrganizerList;
import com.isa.zajavieni.repository.PlaceList;
import com.isa.zajavieni.repository.EventList;
import com.isa.zajavieni.repository.FavouriteEventList;
import com.isa.zajavieni.service.DataParseService;

import java.io.IOException;
import java.text.ParseException;

public class App {

    public static void main(String[] args) throws IOException, ParseException {
        DataParseService parseService = new DataParseService();
        EventList.getEventList().addAll(parseService.parseEvents(EventList.getEventsJson()));
        OrganizerList.getOrganizerList().addAll(parseService.parseOrganizers(OrganizerList.getOrganizersJson()));
        PlaceList.getPlaceList().addAll(parseService.parsePlaces(PlaceList.getPlaceJson()));
        CategoryList.getCategoryList().addAll(parseService.parseCategories(CategoryList.getCategoriesJson()));
        EventList.getEventList().addAll(parseService.parseEvents(EventList.getEventsJson()));
        FavouriteEventList.getFavouriteEventList().addAll(parseService.parseEvents(FavouriteEventList.getFavouriteEventsJson()));
        new MainMenu().mainMenu();
    }
}
