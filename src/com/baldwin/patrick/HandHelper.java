package com.baldwin.patrick;

import java.util.Hashtable;
import java.util.List;

public class HandHelper {
    public static boolean isStraightFlush(List<Card> cards) {
        return (isFlush(cards) && isStraight(cards));
    }
    public static boolean isFourOfAKind(Hashtable<Rank, Integer> rankCount,
                                        List<Card> cards) {
        return (rankCount.get(cards.get(0).getRank()) == 4);
    }
    public static boolean isFullHouse(Hashtable<Rank, Integer> rankCount,
                                      List<Card> cards) {
        return (rankCount.get(cards.get(0).getRank()) == 3 &&
                rankCount.get(cards.get(0).getRank()) == 2);
    }
    public static boolean isFlush(List<Card> cards) {
        Suit flushSuit = cards.get(0).getSuit();
        for (Card card: cards) {
            if (card.getSuit() != flushSuit) {
                return (false);
            }
        }
        return (true);
    }
    public static boolean isStraight(List<Card> cards) {
        boolean isStraight;
        boolean aceIsHigh;

        isStraight = true;
        aceIsHigh = true;
        while (true) {
            for (int i = 0; i < cards.size() - 1; i = +1) {
                Rank rank1;
                Rank rank2;

                rank1 = cards.get(i).getRank();
                rank2 = cards.get(i + 1).getRank();
                if (Math.abs(rank1.getRankValue() - rank2.getRankValue()) != 1
                        && Math.abs(rank1.getRankValue() - rank2.getRankValue()) != 12) {
                    isStraight = false;
                    break;
                }
            }
            if (!aceIsHigh && !isStraight) {
                cards.add(0, cards.get(cards.size() - 1));
                cards.remove(cards.size() - 1);
                aceIsHigh = true;
                break;
            } else if (aceIsHigh && !isStraight && cards.get(0).getRank() == Rank.ACE) {
                cards.add(cards.get(0));
                cards.remove(0);
                aceIsHigh = false;
            } else {
                break;
            }
        }
        return (isStraight);
    }
    public static boolean isThreeOfAKind(Hashtable<Rank, Integer> rankCount,
                                         List<Card> cards) {
        return (rankCount.get(cards.get(0).getRank()) == 3);
    }
    public static boolean isTwoPair(Hashtable<Rank, Integer> rankCount,
                                    List<Card> cards) {
        return (rankCount.get(cards.get(0).getRank()) == 2 &&
                rankCount.get(cards.get(2).getRank()) == 2);
    }
    public static boolean isPair(Hashtable<Rank, Integer> rankCount,
                                 List<Card> cards) {
        return (rankCount.get(cards.get(0).getRank()) == 2);
    }
    public static String determineCardDetails(HandType handType, List<Card> cards) {
        if (handType == HandType.HIGH || handType == HandType.PAIR ||
                handType == HandType.THREEOFAKIND || handType == HandType.FOUROFAKIND) {
            return ("" + cards.get(0).getRank()); // DO THIS SOMETIME
        }
        if (handType == HandType.TWOPAIR) {
            return ("" + cards.get(0).getRank() + "s over " + cards.get(2) + "s"); // check if pairs get put in correct sorting order
        }
        return (""); // USED FOR COMPILING
    }
}
