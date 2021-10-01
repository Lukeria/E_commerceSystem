package com.e_commerceSystem.additional.enums;

public enum ComponentTypes {

    GLASS_TYPE("glassType", "Glass type"),
    PROCESSING("processing", "Processing"),
    ACCESSORY("accessory", "Accessory");

    private String name;
    private String representation;

    ComponentTypes(String name, String representation) {
        this.name = name;
        this.representation = representation;
    }

    public static ComponentTypes valueOfName(String name){

        for (ComponentTypes componentType: values()) {
            if(componentType.getName().equals(name)){
                return componentType;
            }
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public String getRepresentation() {
        return representation;
    }
}
