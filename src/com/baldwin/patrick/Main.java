package com.baldwin.patrick;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Player player1;
        Player player2;
        List<String> argsList;

        try {
            argsList = InputProcessor.splitAndValidateArgs(args);
            player1 = new Player(argsList.subList(0, 6));
            player2 = new Player(argsList.subList(6, argsList.size()));
            System.out.println(player1);
            System.out.println(player2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Please enter two players and their hands.\n" +
                    "Example: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH\n" +
                    "This can be done as one string, " +
                    "two strings (one per player and hand) " +
                    "or individual arguments.");
        }
    }
}
