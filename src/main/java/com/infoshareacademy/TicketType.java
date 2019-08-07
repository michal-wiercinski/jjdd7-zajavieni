package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TicketType {
    @JsonProperty("free")
    FREE("free"),
    @JsonProperty("unknown")
    UNKNOWN("unknown");

    private String type;

    TicketType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "type='" + type + '\'' +
                '}';
    }
}
