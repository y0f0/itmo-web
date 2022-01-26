package ru.itmo.web.lesson4.model;

public enum Color {
    RED("red"),
    GREEN("green"),
    BLUE("blue");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

