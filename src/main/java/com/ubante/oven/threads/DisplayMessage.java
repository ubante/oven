package com.ubante.oven.threads;

/**
 * From http://www.tutorialspoint.com/java/java_multithreading.htm
 * File Name : DisplayMessage.java
 * Create a thread to implement Runnable
 */
public class DisplayMessage implements Runnable
{
  private String message;
  public DisplayMessage(String message)
  {
    this.message = message;
  }
  public void run()
  {
    while(true)
    {
      System.out.print(message);
    }
  }
}