package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Url {
    @JsonProperty("www")
    private String wwwAddress;
    @JsonProperty("fb")
    private String fbSite;

    public Url() {
    }

    public Url(String wwwAddress) {
        this(wwwAddress, null);
    }

    public Url(String wwwAddress, String fbSite) {
        this.wwwAddress = wwwAddress;
        this.fbSite = fbSite;
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

    @Override
    public String toString() {
        return "Url{" +
                "wwwAddress='" + wwwAddress + '\'' +
                ", fbSite='" + fbSite + '\'' +
                '}';
    }
}
