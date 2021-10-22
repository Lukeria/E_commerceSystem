package com.e_commerceSystem.additional.enums;

public enum ProductType {

    GLASS("glass", 1.1),
    MIRROR("mirror", 1.2),
    PARTITION("partition", 1.5),
    SHOWER("shower", 1.4),
    APRON("apron", 1.3);

    private String name;

    private double ratio;

    ProductType(String name, double ratio) {

        this.name = name;
        this.ratio = ratio;
    }

    public String getName() {
        return name;
    }

    public double getRatio() {
        return ratio;
    }
}
