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
}
