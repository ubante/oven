package com.ubante.oven.bitwise;

/**
 * ubante 8/12/14 11:04 AM
 * This is very serious business.
 */
public class CodeReviewers {
    // work is getting silly
    int hex16 = 0x10;
    int hex1 = 0x1;
    int languageExpert = 0;
    int domainExpert = 0;

    boolean computeVotes() {
        if ( (languageExpert > 0) && (domainExpert > 0) ) {
            return true;
        } else {
            return false;
        }
    }

    void display() {
        System.out.println("language votes: " + languageExpert);
        System.out.println("domain votes:   " + domainExpert);

        int totalVotes = languageExpert + domainExpert;
//        if ( totalVotes == 0x11 ) {
        if ( computeVotes() ) {
            System.out.println("PASS: " + totalVotes);
        } else {
            System.out.println("FAIL: " + totalVotes);
        }
    }

    void addLanguageVote() {
        System.out.println("Language expert has casted a vote.");
        languageExpert += hex1;
    }

    void addDomainVote() {
        System.out.println("Domain expert has casted a vote.");
        domainExpert += hex16;
    }


    public static void main(String[] args) {

        CodeReviewers cr = new CodeReviewers();

        System.out.println("Initializing:");
        cr.display();

        System.out.println("\nSome votes:");
        cr.addDomainVote();
//        cr.addLanguageVote();
        cr.display();

        System.out.println("\nMore votes:");
        cr.addDomainVote();
        cr.addDomainVote();
        cr.addLanguageVote();
        cr.display();

        // so bitwise ands aren't so good at this
        // go booleans

    }

}
