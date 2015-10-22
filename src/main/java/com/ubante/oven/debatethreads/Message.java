package com.ubante.oven.debatethreads;

/**
 * From http://www.journaldev.com/1037/java-thread-wait-notify-and-notifyall-example
 */
public class Message {
  private String msg;

  public Message(String str){
    this.msg=str;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String str) {
    this.msg=str;
  }
}


