package com.baldwin.patrick;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Player       player1;
        Player       player2;
        Player       winner;
        int          handComparisonResult;
        List<String> argsList;

        try {
            argsList = InputProcessor.splitAndValidateArgs(args);
            player1 = new Player(argsList.subList(0, 6));
            player2 = new Player(argsList.subList(6, argsList.size()));
            handComparisonResult = player1.getHand().compareTo(player2.getHand());
            if (handComparisonResult == 0) {
                System.out.println("Tie");
            } else {
                winner = handComparisonResult > 0 ? player1 : player2;

                System.out.println(winner.getName() + " wins. - with " +
                        winner.getHand().getHandType() + ": " +
                        winner.getHand().getCardDetails());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Please enter two players and their hands.");
            System.out.println("Example:");
            System.out.println("Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH");
        }
    }
}
