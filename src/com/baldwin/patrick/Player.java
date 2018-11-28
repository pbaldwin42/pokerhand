package com.baldwin.patrick;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private ArrayList<Card> cards;

    public Player(List<String> input) {
        List<String> inputCardStrings;

        inputCardStrings = input.subList(1, input.size());
        this.name = input.get(0).substring(0, input.get(0).length() - 1);
        this.cards = new ArrayList<>();
        for (String cardString: inputCardStrings) {
            this.cards.add(new Card(cardString));
        }
        System.out.println(this.cards);
    }

    @Override
    public String toString() {
        return ("player's name: " + this.name + "\n" +
            "player's cards: " + cards);
    }
}
