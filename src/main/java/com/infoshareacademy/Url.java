package com.infoshareacademy;

public class Url {
    private String wwwAddress;
    private String fbSite;

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
}
