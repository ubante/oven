package com.ubante.oven.threads;

import java.util.concurrent.BlockingQueue;

/**
 * From http://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example
 */
public class Producer implements Runnable {
  private BlockingQueue<Message> queue;

  public Producer(BlockingQueue<Message> q){
    this.queue=q;
  }

  @Override
  public void run() {
    //produce messages
    for(int i=0; i<100; i++){
      Message msg = new Message(""+i);
      try {
        Thread.sleep(i);
        queue.put(msg);
        System.out.println("Produced "+msg.getMsg());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    //adding exit message
    Message msg = new Message("exit");
    try {
      queue.put(msg);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
