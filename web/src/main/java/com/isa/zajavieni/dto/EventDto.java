package com.isa.zajavieni.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventDto {

  private Long id;
  private String name;
  private Date startDate;
  private Date endDate;
  private String addressName;
  private String addressCity;
  private String addressStreet;
  private String addressZipCode;
  private String descShort;
  private String descLong;
  private String wwwAddress;
  private String fbSite;
  private String websiteWithTickets;
  private String organizerName;
  private Integer ticketPool;
  private List<AttachmentDto> attachments = new ArrayList<>();
  private List<BookingDto> bookings = new ArrayList<>();
  private Boolean bookedForUser = false;

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

  public String getAddressName() {
    return addressName;
  }

  public void setAddressName(String addressName) {
    this.addressName = addressName;
  }

  public String getAddressCity() {
    return addressCity;
  }

  public void setAddressCity(String addressCity) {
    this.addressCity = addressCity;
  }

  public String getAddressStreet() {
    return addressStreet;
  }

  public void setAddressStreet(String addressStreet) {
    this.addressStreet = addressStreet;
  }

  public String getAddressZipCode() {
    return addressZipCode;
  }

  public void setAddressZipCode(String addressZipCode) {
    this.addressZipCode = addressZipCode;
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

  public String getWwwAddress() {
    return wwwAddress;
  }

  public void setWwwAddress(String wwwAddress) {
    this.wwwAddress = wwwAddress;
  }

  public String getFbSite() {
    return fbSite;
  }

  public void setFbSite(String fbSite) {
    this.fbSite = fbSite;
  }

  public String getWebsiteWithTickets() {
    return websiteWithTickets;
  }

  public void setWebsiteWithTickets(String websiteWithTickets) {
    this.websiteWithTickets = websiteWithTickets;
  }

  public String getOrganizerName() {
    return organizerName;
  }

  public void setOrganizerName(String organizerName) {
    this.organizerName = organizerName;
  }

  public List<AttachmentDto> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<AttachmentDto> attachments) {
    this.attachments = attachments;
  }

  public Integer getTicketPool() {
    return ticketPool;
  }

  public void setTicketPool(Integer ticketPool) {
    this.ticketPool = ticketPool;
  }

  public List<BookingDto> getBookings() {
    return bookings;
  }

  public void setBookings(List<BookingDto> bookings) {
    this.bookings = bookings;
  }

  public Boolean getBookedForUser() {
    return bookedForUser;
  }

  public void setBookedForUser(Boolean bookedForUser) {
    this.bookedForUser = bookedForUser;
  }
}