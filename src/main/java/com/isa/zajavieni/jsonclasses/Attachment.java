package com.isa.zajavieni.jsonclasses;

public class Attachment {
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