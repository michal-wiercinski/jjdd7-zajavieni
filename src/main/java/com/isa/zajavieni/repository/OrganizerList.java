package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.service.DataParseService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrganizerList {
    private static List<Organizer> organizerList = new ArrayList<>();
    private static final String ORGANIZERS_JSON = "organizers.json";

    public static String getOrganizersJson() {
        return ORGANIZERS_JSON;
    }

    public static List<Organizer> getOrganizerList() {
        return organizerList;
    }

}