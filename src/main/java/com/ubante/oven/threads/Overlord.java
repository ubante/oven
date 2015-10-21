package com.ubante.oven.threads;

/**
 * Created by J on 10/20/2015.
 */
public class Overlord {

  public static void main(String[] args) {
    DebateMessage dm = new DebateMessage("init");

    Person trump = new Person("TRUMP");
    trump.setConch(dm);
    trump.startTalking();
    Person clinton = new Person("CLINTON");
    clinton.setConch(dm);
    clinton.startTalking();
    Debate mccondo = new Debate(dm);
    mccondo.run();
  }
}
