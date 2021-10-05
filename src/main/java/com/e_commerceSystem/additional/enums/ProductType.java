package com.e_commerceSystem.additional.enums;

public enum ProductType {

    GLASS("glass"),
    MIRROR("mirror"),
    PARTITION("partition"),
    SHOWER("shower"),
    APRON("apron");

    private String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
