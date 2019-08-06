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
}
