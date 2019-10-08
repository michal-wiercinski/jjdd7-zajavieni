package com.isa.zajavieni.jsonresponse;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.isa.zajavieni.dto.AttachmentDto;
import com.isa.zajavieni.dto.BookingDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jdo.annotations.Key;

public class EventResponse {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("startDate")
  private String startDate;

  @JsonProperty("endDate")
  private String endDate;

  @JsonProperty("addressName")
  private String addressName;

  @JsonProperty("addressCity")
  private String addressCity;

  @JsonProperty("addressStreet")
  private String addressStreet;

  @JsonProperty("addressZipCode")
  private String addressZipCode;

  @JsonProperty("descShort ")
  private String descShort;

  @JsonProperty("descLong")
  private String descLong;

  @JsonProperty("wwwAddress")
  private String wwwAddress;

  @JsonProperty("fbSite")
  private String fbSite;

  @JsonProperty("websiteWithTickets")
  private String websiteWithTickets;

  @JsonProperty("organizerName")
  private String organizerName;

  @JsonProperty("attachments")
  private List<AttachmentDto> attachments = new ArrayList<>();

  @JsonProperty("bookings")
  private List<BookingDto> bookings = new ArrayList<>();

  @JsonProperty("isBooking")
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

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
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
