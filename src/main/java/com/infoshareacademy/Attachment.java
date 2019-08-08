package com.infoshareacademy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachment {
    @JsonProperty
    private String filename;

    public Attachment() {
    }

    public Attachment(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
