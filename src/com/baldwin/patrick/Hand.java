package com.baldwin.patrick;

import java.util.*;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card>          cards;
    private Hashtable<Rank, Integer> rankCount;
    private HandType                 handType;
    private String                   handDetails;

    public Hand(List<String> cardStrings) {
        cards = new ArrayList<>();
        for (String cardString: cardStrings) {
            cards.add(new Card(cardString));
        }
        storeRankData();
        determineHandType();
        handDetails = HandHelper.determineHandDetails(handType, cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public HandType getHandType() {
        return handType;
    }

    public String getCardDetails() {
        return handDetails;
    }

    public void setHandDetails(String cardDetails) {
        this.handDetails = cardDetails;
    }

    private void storeRankData() {
        rankCount = new Hashtable<>();
        for (Rank rank: Rank.values()) {
            rankCount.put(rank, 0);
        }
        for (Card card: cards) {
            rankCount.put(card.getRank(), rankCount.get(card.getRank()) + 1);
        }
        cards.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                if (rankCount.get(o1.getRank()).equals(rankCount.get(o2.getRank()))) {
                    return (o1.getRank().getRankValue() - o2.getRank().getRankValue());
                } else {
                    return (rankCount.get(o1.getRank()) - rankCount.get(o2.getRank()));
                }
            }
        });
        Collections.reverse(cards);
    }
    private void determineHandType() {
        if (HandHelper.isStraightFlush(cards)) {
            handType = HandType.STRAIGHTFLUSH;
        } else if (HandHelper.isFourOfAKind(rankCount, cards)) {
            handType = HandType.FOUROFAKIND;
        } else if (HandHelper.isFullHouse(rankCount, cards)) {
            handType = HandType.FULLHOUSE;
        } else if (HandHelper.isFlush(cards)) {
            handType = HandType.FLUSH;
        } else if (HandHelper.isStraight(cards)) {
            handType = HandType.STRAIGHT;
        } else if (HandHelper.isThreeOfAKind(rankCount, cards)) {
            handType = HandType.THREEOFAKIND;
        } else if (HandHelper.isTwoPair(rankCount, cards)) {
            handType = HandType.TWOPAIR;
        } else if (HandHelper.isPair(rankCount, cards)) {
            handType = HandType.PAIR;
        } else {
            handType = HandType.HIGH;
        }
    }

    @Override
    public String toString() {
        return ("" + handType + ": " + cards);
    }
    @Override
    public int compareTo(Hand hand2) {
        if (this.handType.getStrength() == hand2.handType.getStrength()) {
            int i;

            for (i = 0; i < this.cards.size(); i += 1) {
                if (i < this.getHandType().getCardsRequired()) {
                    if (this.cards.get(i).getRank() != hand2.getCards().get(i).getRank()) {
                        break;
                    }
                } else if (this.cards.get(i).getRank() != hand2.getCards().get(i).getRank()){
                    this.handType  = HandType.HIGH;
                    hand2.handType = HandType.HIGH;
                    this.handDetails  = "" + this.cards.get(i).getRank();
                    hand2.handDetails = "" + hand2.cards.get(i).getRank();
                    break;
                }
            }
            return (i == this.cards.size() ? 0 :
                    this.cards.get(i).getRank().getRankValue() -
                    hand2.getCards().get(i).getRank().getRankValue());
        } else {
            return (this.handType.getStrength() - hand2.handType.getStrength());
        }
    }
}
