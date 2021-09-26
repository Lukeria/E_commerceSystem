package com.e_commerceSystem.additional;

public enum ProcessingType {

    POLISHING("Полировка", "Processing"),
    GRINDING("Шлифовка", "Grinding"),
    FACET("Фацет", "Facet"),
    HOLE("Отверстие", "Hole");

    private String nameRus;
    private String name;

    ProcessingType(String nameRus, String name) {
        this.nameRus = nameRus;
        this.name= name;
    }

    public String getNameRus() {
        return nameRus;
    }

    public String getName() {
        return name;
    }
}
