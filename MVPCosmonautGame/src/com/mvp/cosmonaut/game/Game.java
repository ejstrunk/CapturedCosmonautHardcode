package com.mvp.cosmonaut.game;

import com.mvp.cosmonaut.global.Direction;
import com.mvp.cosmonaut.pieces.Player;
import com.mvp.cosmonaut.pieces.Room;

import java.util.*;

public class Game {
    private ArrayList<Room> shipLayout;
    private Player player;

    List<String> commands = new ArrayList<>(Arrays.asList(
            "get", "look", "north", "south", "west", "east"
    ));
    List<String> items = new ArrayList<>(Arrays.asList("keycard", "blaster"));

    public Game() {
        this.shipLayout = new ArrayList<Room>();

        shipLayout.add(new Room("Bridge", "Description", Direction.NOEXIT, Direction.NOEXIT, 1, Direction.NOEXIT));
        shipLayout.add(new Room("Weapons Bay", "Description", Direction.NOEXIT, Direction.NOEXIT, 2, 0));
        shipLayout.add(new Room("Hanger", "Description", Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT, 1));

        player = new Player("Vlad", "A lost Cosmonaut", shipLayout.get(0));
    }

    public ArrayList<Room> getShipLayout() {
        return shipLayout;
    }

    public void setShipLayout(ArrayList<Room> shipLayout) {
        this.shipLayout = shipLayout;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    void movePlayerTo(Player p, Room currentRoom) {
        p.setRoom(currentRoom);
    }

    int moveTo(Player player, Direction dir) {
        Room r = player.getRoom();
        int exit;

        switch (dir) {
            case NORTH:
                exit = r.getNorth();
                break;
            case SOUTH:
                exit = r.getSouth();
                break;
            case EAST:
                exit = r.getEast();
                break;
            case WEST:
                exit = r.getWest();
                break;
            default:
                exit = Direction.NOEXIT;
                break;
        }
        if (exit == Direction.NOEXIT) {
            movePlayerTo(player, shipLayout.get(exit));
        }
        return exit;
    }

    public int movePlayerTo(Direction dir) {
        return moveTo(player, dir);
    }

    private void goNorth() {
        updateOutput(movePlayerTo(Direction.NORTH));
    }

    private void goSouth() {
        updateOutput(movePlayerTo(Direction.SOUTH));
    }

    private void goWest() {
        updateOutput(movePlayerTo(Direction.WEST));
    }

    private void goEast() {
        updateOutput(movePlayerTo(Direction.EAST));
    }


    void updateOutput(int roomNumber) {
        String s;
        if (roomNumber == Direction.NOEXIT) {
            s = "You can't go that way!";
        } else {
            Room r = getPlayer().getRoom();
            s = "You are in the " + r.getName() + ". " + r.getDescription();
        }
        System.out.println(s);
    }

    public String ProcessVerb(List<String> wordlist) {
        String verb;
        String msg = "";
        verb = wordlist.get(0);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        } else {
            switch (verb) {
                case "north":
                    goNorth();
                    break;
                case "south":
                    goSouth();
                    break;
                case "west":
                    goWest();
                    break;
                case "east":
                    goEast();
                    break;
                default:
                    msg = verb + " is an invalid command";
                    break;
            }
        }
        return msg;
    }

    public String ProcessVerbNoun(List<String> wordlist) {
        String verb;
        String noun;
        String msg = "";
        verb = wordlist.get(0);
        noun = wordlist.get(1);
        if (!commands.contains(verb)) {
            msg = verb + " is not a known verb! ";
        }
        if (!items.contains(noun)) {
            msg += (noun + " is not a known noun!");
        }
        msg += " invalid command";
        return "";
    }

    public String ParseCommand(List<String> wordlist) {
        String msg;
        if (wordlist.size() == 1) {
            msg = ProcessVerb(wordlist);
        } else if (wordlist.size() == 2) {
            msg = ProcessVerbNoun(wordlist);
        } else {
            msg = "Commands restricted to 2 words";
        }
        return msg;
    }

    public static List<String> WordList(String input) {
        String delims = " \t,.:;?!\"'";
        List<String> strlist = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        String t;

        while (tokenizer.hasMoreTokens()) {
            t = tokenizer.nextToken();
            strlist.add(t);
        }
        return strlist;
    }

    public void Intro() {
        String intro;
        intro = "You are Cosmonaut Vlad, engineer on the exploration-class starship, Vostok-32.\n" +
                "While charting a new system, your ship is attacked and all but destroyed by\n" +
                "an unknown foe. Your only chance of escape is a shuttle in the hanger at the\n" +
                "stern of the Vostok. Normally a simple enough task, but the last remaining\n" +
                "console on the bridge indicates there is one other lifeform still alive on\n" +
                "the ship.....and it is not human...";
        System.out.println(intro);
    }

    public String Execute(String inputstr) {
        List<String> wordlist;
        String s = "ok";
        String lowstr = inputstr.trim().toLowerCase();
        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You must enter a command";
            } else {
                wordlist = WordList(lowstr);
                s = ParseCommand(wordlist);
            }
        }
        return s;
    }

}