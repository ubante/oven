package com.ubante.oven.hearthstone;

/**
 * Created by J on 10/19/2015.
 */
public class YouAreTooPoorException extends Exception {
  public YouAreTooPoorException() {}

  public YouAreTooPoorException(String message) {
    super(message);
  }
}
