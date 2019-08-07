package com.infoshareacademy;

public class Url {
    private String wwwAdress;
    private String fbSite;

    public Url(String wwwAdress) {
        this(wwwAdress, null);
    }

    public Url(String wwwAdress, String fbSite) {
        this.wwwAdress = wwwAdress;
        this.fbSite = fbSite;
    }

    public String getWwwAdress() {
        return wwwAdress;
    }

    public void setWwwAdress(String wwwAdress) {
        this.wwwAdress = wwwAdress;
    }

    public String getFbSite() {
        return fbSite;
    }

    public void setFbSite(String fbSite) {
        this.fbSite = fbSite;
    }
}
