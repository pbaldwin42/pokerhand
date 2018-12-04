package com.baldwin.patrick.pokerhand.card_logic;

public enum Suit {
    SPADES("Spades"),
    CLUBS("Clubs"),
    HEARTS("Hearts"),
    DIAMONDS("Diamonds");

    private String stringValue;

    Suit(String stringValue) {
        this.stringValue = stringValue.intern();
    }

    @Override
    public String toString() {
        return (stringValue);
    }
}
