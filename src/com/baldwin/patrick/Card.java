package com.baldwin.patrick;

import java.util.HashSet;
import java.util.Set;

public class Card {
    private static Set<String> cardsCreated;
    private Rank rank;
    private Suit suit;

    public Card(String cardString) {
        if (cardsCreated == null) {
            cardsCreated = new HashSet<>();
        }
        if (cardString.length() != 2) {
            throw new IllegalArgumentException("\"" + cardString + "\"" +
                " should be only two characters: a value and a rank.");
        }
        storeRank(cardString.charAt(0));
        storeSuite(cardString.charAt(1));
        if (Card.cardsCreated.contains(("" + this.rank + this.suit).intern())) {
            throw new IllegalArgumentException("\"" + cardString + "\"" +
                    " was entered multiple times. One of the players must be cheating.");
        } else {
            Card.cardsCreated.add(("" + this.rank + this.suit).intern());
        }
    }

    private void storeRank(char rankChar) {
        switch (rankChar) {
            case '2':
                this.rank = Rank.TWO;
                break;
            case '3':
                this.rank = Rank.THREE;
                break;
            case '4':
                this.rank = Rank.FOUR;
                break;
            case '5':
                this.rank = Rank.FIVE;
                break;
            case '6':
                this.rank = Rank.SIX;
                break;
            case '7':
                this.rank = Rank.SEVEN;
                break;
            case '8':
                this.rank = Rank.EIGHT;
                break;
            case '9':
                this.rank = Rank.NINE;
                break;
            case 'T':
                this.rank = Rank.TEN;
                break;
            case 'J':
                this.rank = Rank.JACK;
                break;
            case 'Q':
                this.rank = Rank.QUEEN;
                break;
            case 'K':
                this.rank = Rank.KING;
                break;
            case 'A':
                this.rank = Rank.ACE;
                break;
            default:
                throw new IllegalArgumentException("\"" + rankChar + "\"" +
                        " is not a valid card value. Use 2-9 and T, J, Q, K, A.");
        }
    }

    private void storeSuite(char suitChar) {
        switch (suitChar) {
            case 'S':
                this.suit = Suit.SPADES;
                break;
            case 'C':
                this.suit = Suit.CLUBS;
                break;
            case 'H':
                this.suit = Suit.HEARTS;
                break;
            case 'D':
                this.suit = Suit.DIAMONDS;
                break;
            default:
                throw new IllegalArgumentException("\"" + suitChar + "\"" +
                        " is not a valid suit. Use S, C, H, D for Spades, Clubs, Hearts " +
                        "and Diamonds respectively");
        }
    }

    @Override
    public String toString() {
        return ((rank.toString() + " of " + suit.toString()).intern());
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}
