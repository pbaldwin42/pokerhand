package com.baldwin.patrick;

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
        return (this.stringValue);
    }
}
