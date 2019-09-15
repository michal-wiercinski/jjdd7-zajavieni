package com.isa.zajavieni.dto;

import java.util.Date;

public class EventSummary {

    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String addressName;
    private String addressCity;
    private String addressStreet;
    private String addressZipCode;
    private String attachmentFileName;
    private String descShort;
    private String descLong;
    private String wwwAddress;
    private String fbSite;
    private String websiteWithTickets;

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

    public String getAttachmentFileName() {
        return attachmentFileName;
    }

    public void setAttachmentFileName(String attachmentFileName) {
        this.attachmentFileName = attachmentFileName;
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
}