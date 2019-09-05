package com.isa.zajavieni.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "attachment")
public class Attachment {

  @Id
  @Column(name = "attachment_id")
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "file_name")
  String fileName;

  @ManyToOne
  @JoinColumn(name="event_id")
  Event event;

  public Attachment(String fileName, Event event) {
    this.fileName = fileName;
    this.event = event;
  }

  public Attachment() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }
}
