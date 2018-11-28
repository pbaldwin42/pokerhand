package com.baldwin.patrick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    public static List<String> splitAndValidateArgs(String[] args) {
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

        if (result.size() != 12) {
            throw new IllegalArgumentException("Invalid number of items");
        }
        if (!playerNameIsValid(result.get(0)) ||
                !playerNameIsValid(result.get(6))) {
            throw new IllegalArgumentException("Player names must be followed by a colon.");
        }

        return (result);
    }

    private static boolean playerNameIsValid(String playerName) {
        return (playerName.length() > 1 &&
                playerName.charAt(playerName.length() - 1) == ':');
    }
}
