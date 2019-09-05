package com.isa.zajavieni.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "media_link")
public class MediaLink {

  @Id
  @Column(name = "media_link_id")
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "www_address")
  String wwwAddress;

  @Column(name = "fb_site")
  String fbSite;

  @Column(name = "website_with_tickets")
  String websiteWithTickets;

  public MediaLink(String wwwAddress, String fbSite, String websiteWithTickets) {
    this.wwwAddress = wwwAddress;
    this.fbSite = fbSite;
    this.websiteWithTickets = websiteWithTickets;
  }

  public MediaLink() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
}
