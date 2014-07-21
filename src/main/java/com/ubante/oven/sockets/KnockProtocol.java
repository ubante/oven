package com.ubante.oven.sockets;

/**
 * From oracle.com
 */
public class KnockProtocol {
    private static final int WAITING = 0;
    private static final int SENTKNOCK = 1;
    private static final int SENTCLUE = 2;
    private static final int ANOTHER = 3;
    private static final int NUMJOKES = 5;
    private int state = WAITING;
    private int currentJoke = 0;
    private String kkString = "Knock! Knock!";
    private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who"};
    private String[] answers = { "Turnip the heat, it's cold in here!",
            "I didn't know you could yodel!",
            "Bless you!",
            "Is there an owl in here?",
            "Is there an echo in here?" };

    public String processInput(String theInput) {
        String theOutput = null;

        if (state == WAITING) {
            theOutput = kkString;
            state = SENTKNOCK;
        } else if (state == SENTKNOCK) {
            if (theInput.equalsIgnoreCase("Who's there?")) {
                theOutput = clues[currentJoke];
                state = SENTCLUE;
            } else {
                theOutput = "You're supposed to say \"Who's there?\"!  Try again.\n" +
                        kkString;
            }
        } else if (state == SENTCLUE) {
            if (theInput.equalsIgnoreCase(clues[currentJoke] + " who?")) {
                theOutput = answers[currentJoke] + " Want another? [y/n]";
                state = ANOTHER;
            } else {
                theOutput = "You're supposed to say \"" + clues[currentJoke] + " who?\"\n" +
                        "Try again.  " + kkString;
                state = SENTKNOCK;
            }
        } else if (ANOTHER == state) {
            if (theInput.equalsIgnoreCase("y")) {
                theOutput = kkString;
                if (currentJoke == (NUMJOKES - 1)) {
                    currentJoke = 0;
                } else {
                    currentJoke++;
                }
                state = SENTKNOCK;
            } else {
                theOutput = "Bye.";
                state = WAITING;
            }
        }

        return theOutput;
    }
}





