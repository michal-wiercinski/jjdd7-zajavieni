package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Organizer;

import java.util.List;

public class OrganizerPrinter {

    public void printOrganizers(List<Organizer> organizers){
        System.out.println("id organizator");
        for (Organizer organizer:organizers) {
            System.out.println(organizer.getId()+ " " + organizer.getDesignation());
        }
    }
}
