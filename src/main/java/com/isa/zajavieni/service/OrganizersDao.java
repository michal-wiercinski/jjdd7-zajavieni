package com.isa.zajavieni.service;

import com.isa.zajavieni.jsonclasses.Organizer;
import com.isa.zajavieni.repository.OrganizerList;

import java.util.Optional;

public class OrganizersDao {

    public Optional<Organizer> getOrganizerById(Long id) {
        for (Organizer organizer : OrganizerList.getOrganizerList()) {
            if (organizer.getId().equals(id)) {
                return Optional.of(organizer);
            }
        }
        return Optional.empty();
    }
}
