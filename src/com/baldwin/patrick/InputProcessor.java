package com.baldwin.patrick;

import java.util.ArrayList;
import java.util.Arrays;

public class InputProcessor {
    public static String processInput(String[] args) {
        ArrayList<String> argsArrayList;

        argsArrayList = splitArgs(args);

        return (argsArrayList.toString());
    }

    private static ArrayList<String> splitArgs(String[] args) {
        ArrayList<String> result;

        result = new ArrayList<>();

        if (args.length == 1) {
            result = new ArrayList<>(Arrays.asList(args[0].split("\\s+")));
        } else if (args.length == 2) {
            for (String arg: args) {
                result.addAll(new ArrayList<>(Arrays.asList(arg.split("\\s+"))));
            }
        } else if (args.length == 12) {
            result = new ArrayList<>(Arrays.asList(args));
        }

        if (result.size() != 12 ||
                !playerNameIsValid(result.get(0)) ||
                !playerNameIsValid(result.get(6))) {
            throw new IllegalArgumentException(
                    "Please enter two players and their hands.\n" +
                    "Example: Black: 2H 3D 5S 9C KD White: 2C 3H 4S 8C AH\n" +
                    "This can be done as one string, " +
                    "two strings (one per player and hand) " +
                    "or individual arguments."
            );
        }

        return (result);
    }

    private static boolean playerNameIsValid(String playerName) {
        if (playerName.charAt(playerName.length() - 1) == ':') {
            return (true);
        } else {
            return (false);
        }
    }
}
