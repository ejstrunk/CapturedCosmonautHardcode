package com.mvp.cosmonaut.pieces;

public class GamePiece {
    // Defines all objects

    // FIELDS
    private String name;
    private String description;

    // CONSTRUCTORS
    public GamePiece(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // ACCESSOR METHODS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
