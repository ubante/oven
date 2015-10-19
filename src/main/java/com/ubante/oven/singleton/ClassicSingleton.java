package com.ubante.oven.singleton;

/**
 * From http://www.javaworld.com/article/2073352/core-java/simply-singleton.html
 */
public class ClassicSingleton {
  private static ClassicSingleton instance = null;
  private static String config1 = "init1";
  private static String config2 = "init2";

  protected ClassicSingleton() {} // exists to defeat instantiation XXX final mebbe?

  public static ClassicSingleton getInstance() {
    if (instance == null) {
      instance = new ClassicSingleton();
    }

    return instance;
  }

  public void displayState() {
    System.out.println("\nHere is the config state:");
    System.out.println("config1: " + config1);
    System.out.println("config2: " + config2);
  }

  public static void setConfig1(String config1) {
    ClassicSingleton.config1 = config1;
  }

  public static void setConfig2(String config2) {
    ClassicSingleton.config2 = config2;
  }
}
