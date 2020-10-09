package com.mvp.cosmonaut.pieces;

public class Room extends GamePiece {

    private int north, east, south, west;

    public Room(String name, String description, int north, int south, int west, int east) {
        super(name, description);
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
    }

    public int getNorth() {
        return north;
    }

    public void setNorth(int north) {
        this.north = north;
    }

    public int getEast() {
        return east;
    }

    public void setEast(int east) {
        this.east = east;
    }

    public int getSouth() {
        return south;
    }

    public void setSouth(int south) {
        this.south = south;
    }

    public int getWest() {
        return west;
    }

    public void setWest(int west) {
        this.west = west;
    }
}