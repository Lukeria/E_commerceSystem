package com.e_commerceSystem.additional.enums;

public enum ProcessingType {

    POLISHING("processing"),
    GRINDING("grinding"),
    FACET("facet"),
    HOLE("hole");

    private String name;

    ProcessingType(String name) {
        this.name= name;
    }

    public String getName() {
        return name;
    }
}
