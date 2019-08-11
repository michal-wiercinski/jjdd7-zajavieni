package com.infoshareacademy;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                '}';
    }
}
