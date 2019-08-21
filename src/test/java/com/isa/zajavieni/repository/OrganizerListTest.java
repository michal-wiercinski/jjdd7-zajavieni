package com.isa.zajavieni.repository;

import com.isa.zajavieni.jsonclasses.Organizer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganizerListTest {

    @Test
    void getOrganizerList_testIfListIsNotNull() throws IOException {
        List<Organizer> list = new OrganizerList().getOrganizerList();

        assertNotNull(list);
    }
}