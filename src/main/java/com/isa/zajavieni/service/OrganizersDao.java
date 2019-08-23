package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Organizer;

import java.io.IOException;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OrganizersDao {

    private DataParseService dataParseService = new DataParseService();

    public List<Organizer> getOrganizers() throws IOException {
        return dataParseService.parseOrganizers("organizers.json");
    }

    public Optional<Organizer> getOrganizerById(Long id) throws IOException {
        for (Organizer organizer : getOrganizers()) {
            if (organizer.getId().equals(id)) {
                return Optional.of(organizer);
            }
        }
        return Optional.empty();
    }
}
