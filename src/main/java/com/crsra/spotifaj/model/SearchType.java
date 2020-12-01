package com.crsra.spotifaj.model;

public enum SearchType {
    TRACK("track"),
    ARTIST("artist");
    private String type;

    SearchType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
