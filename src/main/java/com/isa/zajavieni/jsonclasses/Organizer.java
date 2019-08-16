package com.isa.zajavieni.jsonclasses;

public class Organizer {
    private Long id;
    private String designation;

    public Long getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                '}';
    }
}