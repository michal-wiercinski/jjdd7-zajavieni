package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Organizer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

class OrganizersDaoTest {

    @Test
    void getOrganizerById_testIfReturnOrganizerIsNotNull() throws IOException {
        OrganizersDao organizersDao = new OrganizersDao();
        Long id = 37L;

        Optional<Organizer> expectedOrganizer = organizersDao.getOrganizerById(id);

        assertNotNull(expectedOrganizer);
    }

    @Test
    void getOrganizerById_testIfReturnOrganizerIsEmpty() throws IOException {
        OrganizersDao organizersDao = new OrganizersDao();
        Long id = 437L;

        Optional<Organizer> expectedOrganizer = organizersDao.getOrganizerById(id);

        assertThat(expectedOrganizer).isEqualTo(Optional.empty());
    }
}