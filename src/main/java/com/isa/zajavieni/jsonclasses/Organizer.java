package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Organizer {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("designation")
    private String designation;

    public Organizer() {
    }

    public Organizer(Long id, String designation) {
        this.id = id;
        this.designation = designation;
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