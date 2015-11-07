package com.ubante.oven.hearthstonebad;

/**
 * Created by J on 10/19/2015.
 */
public class AlreadyPlayingArenaException extends Exception {
  public AlreadyPlayingArenaException() {}

  public AlreadyPlayingArenaException(String message) {
    super(message);
  }
}
