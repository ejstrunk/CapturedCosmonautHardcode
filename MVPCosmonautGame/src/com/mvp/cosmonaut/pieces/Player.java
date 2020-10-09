package com.mvp.cosmonaut.pieces;

import com.mvp.cosmonaut.game.ShipLayout;

public class Player extends GamePiece {

    private Room room; // Current Room

    public Player(String name, String description, Room currentRoom) {
        super(name, description);
        this.room = currentRoom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}