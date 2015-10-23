package com.ubante.oven.debatethreads;

import java.util.concurrent.BlockingQueue;

/**
 * Created by J on 10/20/2015.
 */
public class Debate implements Runnable {
  DebateMessage conch;
  private BlockingQueue<Message> queue;
  int questionDelay = 1000;
  String[] questions = {
      "How would you address the debt?",
      "What is the solution to government overreach?",
      "Where do you stand on environmental issues?",
      "How would you improve public health?",
      "Where would you begin to improve our tax code?",
      "Do you think the media accurately reports the news?",
      "If you were a pear, would you eat an apple?",
      "A horse walks into a bar....",
      "Do you walk like an Egyptian?",
      "24 or Homeland?",
      "Diet Coke or Miller Light?"
  };

  public void setQueue(BlockingQueue<Message> queue) {
    this.queue = queue;
  }

  Debate (DebateMessage msg) {
    conch = msg;
  }

  void speak(String bigWords) {
    System.out.println("\nJOLI News: " + bigWords);
  }

  void poseQuestion(String question) {
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
      Thread.sleep(questionDelay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // The first approach uses synchronized.
    poseQuestion("How are you doing?");
    try {
      Thread.sleep(questionDelay);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // The second approach uses Blocking Queue.
    for (int i=1; i<=10; i++) {
      speak(questions[i-1]);
      try {
        queue.put(new Message("q" + i));
        Thread.sleep(questionDelay);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    speak("That's all the time we have tonight.");
    // put this twice - once for each Person
    try {
      queue.put(new Message("exit"));
      queue.put(new Message("exit"));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  void beginDebate() {
    speak("It's now time to start the debate!!!\n");
    Thread t = new Thread(this, "mccondo");
    t.start();
  }
}














