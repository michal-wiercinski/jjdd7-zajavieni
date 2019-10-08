package com.isa.zajavieni.entity.fromapi;

import com.isa.zajavieni.entity.createdentity.PopularityOrganizer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@NamedQueries(
    @NamedQuery(
        name = "Organizer.SearchByFirstLetter",
        query = "SELECT o FROM Organizer o WHERE o.designation LIKE CONCAT(:first_letter,'%') " +
            "ORDER BY o.designation"
    )
)
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

  @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "organizer_popularity_id", unique = true)
  PopularityOrganizer popularityOrganizer;

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

  public PopularityOrganizer getPopularityOrganizer() {
    return popularityOrganizer;
  }

  public void setPopularityOrganizer(PopularityOrganizer popularityOrganizer) {
    this.popularityOrganizer = popularityOrganizer;
  }
}
