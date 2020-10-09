package com.mvp.cosmonaut.client;

import com.mvp.cosmonaut.game.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheCapturedCosmonaut {
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output;
        Game game = new Game();
        in = new BufferedReader(new InputStreamReader(System.in));
        game.Intro();
        do {
            System.out.println("> ");
            input = in.readLine();
            output = game.Execute(input);
            System.out.println(output);
        } while (!"q".equals(input));
    }
}