package com.infoshareacademy;

public class Organizer {
    private Long organizerID;
    private String name;

    public Organizer(Long organizerID, String name) {
        this.organizerID = organizerID;
        this.name = name;
    }

    public Long getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(Long organizerID) {
        this.organizerID = organizerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
