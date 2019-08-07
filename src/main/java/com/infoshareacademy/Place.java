package com.infoshareacademy;

public class Place {
    private Long placeID;
    private Adress adress;
    private String name;
    private String subname;

    public Place(Long placeID, Adress adress, String name, String subname) {
        this.placeID = placeID;
        this.adress = adress;
        this.name = name;
        this.subname = subname;
    }

    public Place(Long placeID, Adress adress, String name) {
        this(placeID, adress, name, null);
    }

    public Long getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Long placeID) {
        this.placeID = placeID;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }
}
