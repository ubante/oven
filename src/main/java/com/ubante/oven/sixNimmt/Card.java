package com.ubante.oven.sixNimmt;

/**
 * This is a card.  And I need this.
 */
public class Card implements Comparable<Card> {
//public class Card {
    Integer faceValue;
    Integer beefHeads;

    public Card (int value) {
        faceValue = value;
        assignBeefHeads();
    }

    public String toString() {
        return faceValue.toString() + " & " + beefHeads.toString() + " beef heads.";
    }

    @Override
    public int compareTo(Card o) {
        return faceValue - o.faceValue;
    }

    // All cards start with one beef head.
    // If multiple of 5, +1 beef heads.
    // If multiple of 10, +1 beef heads.
    // If multiple of 11, +4 beef heads.
    // If 55, +1 beef heads.
    //
    // 7 beef heads: 55
    // 5 beef heads: 11, 22, 33, 44, 66, 77, 88, 99
    // 3 beef heads: 10, 20, 30, 40, 50, 60, 70, 80, 90, 100
    // 2 beef heads: 5, 15, 25, 35, 45, 65, 75, 85, 95
    // 1 beef heads: the remaining 76 cards
    void assignBeefHeads() {
        beefHeads = 1;
        if (faceValue % 5 == 0) { beefHeads++; }
        if (faceValue % 10 == 0) { beefHeads++; }
        if (faceValue % 11 == 0) { beefHeads = beefHeads + 4; }
        if (faceValue == 55) { beefHeads++; }
    }

}
