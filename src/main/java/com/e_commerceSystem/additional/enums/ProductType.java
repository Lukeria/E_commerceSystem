package com.e_commerceSystem.additional.enums;

public enum ProductType {

    GLASS("glass", "Glass", "Стекло"),
    MIRROR("mirror", "Mirrors", "Зеркала"),
    PARTITION("partition", "Glass partitions", "Стеклянные перегородки"),
    SHOWER("shower", "Showers", "Душевые кабины"),
    APRON("apron", "Kitchen aprons", "Кухонные фартуки");

    private String name;
    private String representation;
    private String representationRus;

    ProductType(String name, String representation, String representationRus) {
        this.name = name;
        this.representation = representation;
        this.representationRus = representationRus;
    }

    public String getName() {
        return name;
    }

    public String getRepresentation() {
        return representation;
    }

    public String getRepresentationRus() {
        return representationRus;
    }
}
