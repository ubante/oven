package com.ubante.oven.oscars;

/**
 * For those funny ideas
 *
 * It feels gross to have two objects be fields of each other.  But I guess that is okay.
 */
public class TestRunner {

  void go() {
    President abe = new President("Lincoln");
    TopTenList topTenBest = new TopTenList("The Best Kentukians");
    topTenBest.setBestEver(abe);

    System.out.printf("#1 in %s is %s\n", topTenBest.listName, topTenBest.bestEver.name);
    System.out.println("I am: " + abe.name);
    System.out.println("I am on the list of " + abe.listImOn.listName);
  }

  public static void main(String[] args) {
    TestRunner tr = new TestRunner();
    tr.go();
  }

  class President {
    String name;
    TopTenList listImOn;

    President(String name) {
      this.name = name;
    }
  }

  class TopTenList {
    President bestEver;
    String listName;

    TopTenList(String title) {
      listName = title;
    }

    public void setBestEver(President bestEver) {
      this.bestEver = bestEver;
      bestEver.listImOn = this;
    }
  }

}
