package com.ubante.oven.poker;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a list of random cards.  Duplicates are allowed.  There are no limits like those found
 * in a 52-card deck.
 */
public class CardStack {
    static int stackSize = 1000; // 100k
    List<Card> stack = new ArrayList<Card>();

    CardStack() {
        for (int i=1; i<=stackSize; i++) {
            stack.add(Card.getRandom());
        }
    }

    static CardStack getInstance() {
        return new CardStack();
    }

    static CardStack getInstance(int newSize) {
        stackSize = newSize;
        return new CardStack();
    }

    List<Card> getStack() { return stack; }

    Card getCard() {
        Card c = stack.get(0);
        stack.remove(0);

        return c;
    }

    /**
     * HandDistribution shows that this is random.
     * @param args
     */
    public static void main(String[] args) {
        CardStack stack;
        stack = CardStack.getInstance();
        stack = CardStack.getInstance(100);
        System.out.println("Size is: "+stack.getStack().size());

        Card c = stack.getCard();
        c.println();
        c = stack.getCard();
        c.println();
        c = stack.getCard();
        c.println();
        c = stack.getCard();
        c.println();
        c = stack.getCard();
        c.println();

    }
}
