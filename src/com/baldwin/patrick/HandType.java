package com.baldwin.patrick;

public enum HandType {
    HIGH("high card", 1),
    PAIR("pair", 2),
    TWOPAIR("two pair", 3),
    THREEOFAKIND("three of a kind", 4),
    STRAIGHT("straight", 5),
    FLUSH("flush", 6),
    FULLHOUSE("full house", 7),
    FOUROFAKIND("four of a kind", 8),
    STRAIGHTFLUSH("straight flush", 9);

    private String  stringValue;
    private int     strength;

    private HandType(String stringValue, int strength) {
        this.stringValue = stringValue.intern();
        this.strength    = strength;
    }

    public int getStrength() {
        return (this.strength);
    }

    @Override
    public String toString() {
        return (this.stringValue);
    }
}
