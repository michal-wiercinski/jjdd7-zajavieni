package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaLink {

    @JsonProperty("www")
    private String wwwAddress;

    @JsonProperty("fb")
    private String fbSite;

    @JsonProperty("tickets")
    private String websiteWithTickets;

    public MediaLink() {
    }

    public MediaLink(String wwwAddress, String fbSite, String websiteWithTickets) {
        this.wwwAddress = wwwAddress;
        this.fbSite = fbSite;
        this.websiteWithTickets = websiteWithTickets;
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

    public MediaLink(String wwwAddress, String fbSite) {
        this(wwwAddress, fbSite, null);
    }

    public MediaLink(String wwwAddress) {
        this(wwwAddress, null, null);
    }

    @Override
    public String toString() {
        return "Url{" +
                "wwwAddress='" + wwwAddress + '\'' +
                ", fbSite='" + fbSite + '\'' +
                ", websiteWithTickets='" + websiteWithTickets + '\'' +
                '}';
    }
}