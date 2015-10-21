package com.ubante.oven.threads;

/**
 * Created by J on 10/20/2015.
 */
public class Person implements Runnable {
  String name;
  Thread t;
  private DebateMessage conch;

  Person (String n) {
    name = n;
  }

  void setConch (DebateMessage msg) {
    conch = msg;
  }

  void say(String bigWords) {
    System.out.println(name + ": " + bigWords);
  }

  @Override
  public void run() {
    say("You should vote for me.");
    try {
      Thread.sleep(50);
      say("I'm the best so I'm better than that other person over there.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    synchronized (conch) {
      try {
        conch.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      say("big words, baby, big words.");
    }
  }

  void startTalking() {
    System.out.println("Hello, I'm " + name + " and I'm the best.  Watch me in this debate.");
    t = new Thread(this, name);
    t.start();
  }
}











