package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.repository.OrganizerList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

class OrganizersDaoTest {

    @Test
    void getOrganizerById_testIfReturnOrganizerIsNotNull() throws IOException {
        OrganizersDao organizersDao = new OrganizersDao();
        List<Organizer> organizerList = new DataParseService().parseOrganizers(OrganizerList.getOrganizersJson());
        Long id = 37L;
        Organizer organizer = organizerList.get(0);

        Optional<Organizer> expectedOrganizer = organizersDao.getOrganizerById(id);

        assertNotNull(expectedOrganizer);
    }

    @Test
    void getOrganizerById_testIfReturnOrganizerIsEmpty() throws IOException {
        OrganizersDao organizersDao = new OrganizersDao();
        List<Organizer> organizerList = new DataParseService().parseOrganizers(OrganizerList.getOrganizersJson());
        Long id = 437L;
        Organizer organizer = organizerList.get(0);

        Optional<Organizer> expectedOrganizer = organizersDao.getOrganizerById(id);

        assertNotNull(expectedOrganizer);
    }
}