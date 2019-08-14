package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachment {
    @JsonProperty("fileName")
    private String filename;

    public Attachment() {
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "filename='" + filename + '\'' +
                '}';
    }
}