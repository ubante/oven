package com.ubante.oven.debatethreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by J on 10/20/2015.
 */
public class Overlord {

  public static void main(String[] args) {
    DebateMessage dm = new DebateMessage("init");
    BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);

    Person trump = new Person("TRUMP");
    trump.setConch(dm);
    trump.setQueue(queue);
    trump.startTalking();

    Person clinton = new Person("CLINTON");
    clinton.setConch(dm);
    clinton.startTalking();
    clinton.setQueue(queue);

    Debate mccondo = new Debate(dm);
    mccondo.setQueue(queue);
    mccondo.beginDebate();
  }

}
