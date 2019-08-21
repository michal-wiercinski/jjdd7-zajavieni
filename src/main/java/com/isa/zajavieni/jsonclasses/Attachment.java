package com.isa.zajavieni.jsonclasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachment {
    @JsonProperty("fileName")
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "filename='" + fileName + '\'' +
                '}';
    }
}