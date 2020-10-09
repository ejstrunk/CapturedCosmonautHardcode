package com.mvp.cosmonaut.game;

import com.mvp.cosmonaut.global.Direction;
import com.mvp.cosmonaut.pieces.Room;

import java.util.ArrayList;
import java.util.Arrays;

public class ShipLayout {
    private ArrayList<Room> map = new ArrayList<>(Arrays.asList(
            new Room("Bridge", "Description", Direction.NOEXIT, Direction.NOEXIT, 1, Direction.NOEXIT),
            new Room("Weapons Bay", "Description", Direction.NOEXIT, Direction.NOEXIT, 2, 0),
            new Room("Hanger", "Description", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 1))
    );

}