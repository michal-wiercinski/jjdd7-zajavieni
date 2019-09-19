package com.isa.zajavieni.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Organizer.foundOrganizer",
                query = "SELECT o FROM Organizer o WHERE o.designation LIKE CONCAT('%',:phrase,'%')"
        )
})

@Entity
@Table(name = "organizer")
public class Organizer {

    @Id
    @Column(name = "organizer_id")
    Long id;

    @Column(name = "designation")
    String designation;

    @OneToMany(mappedBy = "organizer")
    List<Event> events = new ArrayList<>();

    public Organizer(String designation) {
        this.designation = designation;
    }

    public Organizer() {
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
