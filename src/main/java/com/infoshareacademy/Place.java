package com.infoshareacademy;

public class Place {
    private Integer placeID;
    private Adress adress;
    private String namePlace;
    private String subname;

    public Place(Integer placeID, Adress adress, String namePlace) {
        this(placeID, adress,namePlace,null);
    }

    public Place(Integer placeID, Adress adress, String namePlace, String subname) {
        this.placeID = placeID;
        this.adress = adress;
        this.namePlace = namePlace;
        this.subname = subname;
    }
}
