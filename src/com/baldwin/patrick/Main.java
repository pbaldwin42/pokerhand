package com.baldwin.patrick;

public class Main {

    public static void main(String[] args) {
        try {
            InputProcessor.processInput(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
