package com.isa.zajavieni.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "event")
public class Event {

  @Id
  @Column(name = "event_id")
  Long id;

  @Column(name = "name")
  String name;

  @Column(name = "desc_short")
  String descShort;

  @Column(name = "desc_long")
  String descLong;

  @Column(name = "active")
  Boolean active;

  @Column(name = "start_date")
  Date startDate;

  @Column(name = "end_date")
  Date endDate;

  @Column(name = "type")
  String type;

  @OneToMany(mappedBy = "event")
  List<Attachment> attachment = new ArrayList<>();

  @OneToOne
  @JoinColumn(name = "media_link_id", unique = true)
  MediaLink mediaLink;

  @ManyToOne
  @JoinColumn (name = "address_id")
  Address address;

  @ManyToOne
  @JoinColumn (name = "organizer_id")
  Organizer organizer;

  @ManyToOne
  @JoinColumn (name = "category_id")
  Category category;

  public Event(String name, String descShort, String descLong, Boolean active,
      Date startDate, Date endDate, String type) {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
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
}