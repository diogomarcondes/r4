package com.example.demo.enums;

public enum FlowEnum {

    FIRST_FLOW("firstFlow"),
    SECOND_FLOW("secondFlow"),
    THIRD_FLOW("Resilience4jService");

    private final String value;

    FlowEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
