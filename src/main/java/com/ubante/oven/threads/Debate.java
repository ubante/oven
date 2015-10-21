package com.ubante.oven.threads;

/**
 * Created by J on 10/20/2015.
 */
public class Debate implements Runnable {
  DebateMessage conch;
  Debate (DebateMessage msg) {
    conch = msg;
  }

  void speak(String bigWords) {
    System.out.println("JOLI News: " + bigWords);
  }

  void poseQuestion(String question) {
    System.out.println();
    speak(question);
    synchronized (conch) {
      conch.setMsg("first");
      conch.notifyAll();
    }
  }

  @Override
  public void run() {
    speak("Welcome to this highly anticipated debate.");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    poseQuestion("How's the weather?");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    poseQuestion("How you doin'?");
  }
}
