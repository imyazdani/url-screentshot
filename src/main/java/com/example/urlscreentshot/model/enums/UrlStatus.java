package com.example.urlscreentshot.model.enums;

public enum UrlStatus {
    PENDING("PENDING"),
    DOWNLOADING("DOWNLOADING"),
    DONE("DONE"),
    FAILED("FAILED");

    public final String label;

    private UrlStatus(String label){
        this.label = label;
    }
}
