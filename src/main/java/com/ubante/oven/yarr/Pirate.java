package com.ubante.oven.yarr;

/**
 * Created by J on 3/14/2015.
 */
public class Pirate {
  static int highestPirateId;
  int argnessNumber;
  int pirateId;
  String name;
  String argness;

  public Pirate(int argnessNumber, int pirateId, String name, String argness) {
    this.argnessNumber = argnessNumber;
    this.name = name;
    this.argness = argness;

    if ( pirateId == -1 ) { pirateId = highestPirateId+1; }
    if ( pirateId > highestPirateId ) { highestPirateId = pirateId; }
    this.pirateId = pirateId;
  }

  public Pirate(String name) {
    this(0,-1,name,"Yaaarr");
  }
}
