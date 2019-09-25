package com.isa.zajavieni.entity;

import com.isa.zajavieni.jsonclasses.TicketType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@NamedQueries({
        @NamedQuery(
                name = "Event.upcomingEvents",
                query = "SELECT e FROM  Event e WHERE e.startDate >= :time ORDER BY e.startDate"
        ),
        @NamedQuery(
                name = "Event.counterByDate",
                query = "SELECT count(e) FROM Event e WHERE e.startDate >= :time"
        ),
        @NamedQuery(
                name = "Event.foundEvents",
                query = "SELECT e FROM Event e WHERE e.name LIKE CONCAT('%',:phrase,'%')"
        ),
        @NamedQuery(
                name = "Event.filterByOrganizer",
                query = "SELECT e FROM Event e WHERE e.organizer.id = :id_organizer " +
                        "AND e.startDate >= :time ORDER BY e.startDate"
        ),
        @NamedQuery(
                name = "Event.counterByOrganizer",
                query = "SELECT count(e) FROM Event e WHERE e.organizer.id = :id_organizer " +
                        "AND e.startDate >= :time"
        ),
        @NamedQuery(
                name = "Event.findFavouriteEvents",
                query = "SELECT e FROM Event e INNER JOIN e.users u WHERE u.id = :id"
        )
})
@Entity
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "event_id")
    Long id;

  @Column(name = "name")
  String name;

  @Column(name = "desc_short", columnDefinition = "TEXT")
  String descShort;

  @Column(name = "desc_long", columnDefinition = "TEXT")
  String descLong;

  @Column(name = "active")
  Boolean active;

  @Column(name = "start_date")
  Date startDate;

  @Column(name = "end_date")
  Date endDate;

  @Column(name = "type")
  TicketType type;

  @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
  List<Attachment> attachment = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "media_link_id", unique = true)
  MediaLink mediaLink;

  @ManyToOne
  @JoinColumn(name = "address_id")
  Address address;

  @ManyToOne
  @JoinColumn(name = "organizer_id")
  Organizer organizer;

  @ManyToOne
  @JoinColumn(name = "category_id")
  Category category;

  @ManyToMany(mappedBy = "events")
  List<User> users;

  public Event(String name, String descShort, String descLong, Boolean active,
      Date startDate, Date endDate, TicketType type) {
    this.name = name;
    this.descShort = descShort;
    this.descLong = descLong;
    this.active = active;
    this.startDate = startDate;
    this.endDate = endDate;
    this.type = type;

  }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescShort() {
        return descShort;
    }

    public void setDescShort(String descShort) {
        this.descShort = descShort;
    }

    public String getDescLong() {
        return descLong;
    }

    public void setDescLong(String descLong) {
        this.descLong = descLong;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public List<Attachment> getAttachment() {
        return attachment;
    }

    public void setAttachment(List<Attachment> attachment) {
        this.attachment = attachment;
    }

    public MediaLink getMediaLink() {
        return mediaLink;
    }

    public void setMediaLink(MediaLink mediaLink) {
        this.mediaLink = mediaLink;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public Category getCategory() {
        return category;
    }

  public void setCategory(Category category) {
    this.category = category;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
}
