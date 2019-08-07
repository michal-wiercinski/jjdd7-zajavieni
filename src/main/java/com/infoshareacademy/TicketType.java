package com.infoshareacademy;

public enum TicketType {
    FREE("free"), UNKNOWN("unknown");

    private String type;

    TicketType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
