package com.baldwin.patrick.pokerhand;

import com.baldwin.patrick.pokerhand.hand_logic.Hand;

import java.util.List;

public class Player {
    private String  name;
    private Hand hand;

    public Player(List<String> input) {
        this.name = input.get(0).substring(0, input.get(0).length() - 1);
        this.hand = new Hand(input.subList(1, input.size()));
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}
