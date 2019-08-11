package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum TicketType {
    @JsonProperty("type")
    UNKNOWN("unknown"),

    @JsonProperty("type")
    FREE("free");

    private String type;

    TicketType(String type) {
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @JsonCreator
    public static TicketType deserialize(@JsonProperty("type") String type) {
        for (int i = 0; i < TicketType.values().length; i++) {
            if (TicketType.values()[i].getType().equals(type)) {
                return TicketType.values()[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return type;
    }
}
