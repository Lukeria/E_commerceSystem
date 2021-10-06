package com.e_commerceSystem.additional.enums;

public enum ProcessingType {

    PROCESSING("processing"),
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
