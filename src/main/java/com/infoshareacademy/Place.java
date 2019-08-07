package com.infoshareacademy;

public class Place {
    private Long placeID;
    private Adress adress;
    private String namePlace;
    private String subname;

    public Place(Long placeID, Adress adress, String namePlace, String subname) {
        this.placeID = placeID;
        this.adress = adress;
        this.namePlace = namePlace;
        this.subname = subname;
    }

    public Place(Long placeID, Adress adress, String namePlace) {
        this(placeID, adress, namePlace, null);
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

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }
}
