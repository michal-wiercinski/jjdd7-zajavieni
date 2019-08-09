package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TicketType {

    @JsonProperty("free") FREE,
    @JsonProperty("unknown")UNKNOWN;



//    private String type;
//
//    TicketType(String type) {
//        this.type = type;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    @Override
//    public String toString() {
//        return type;
//    }
}
