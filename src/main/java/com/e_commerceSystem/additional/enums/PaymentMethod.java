package com.e_commerceSystem.additional.enums;

public enum PaymentMethod {

    CASH("cash"),
    CARD("card");

    private String name;

    PaymentMethod(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
