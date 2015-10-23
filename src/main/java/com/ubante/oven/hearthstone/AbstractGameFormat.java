package com.ubante.oven.hearthstone;

/**
 * I'm assuming for each format, there's precisely one universe for that format.  Here are the known formats:
 * - ladder
 * - legend, which is once you graduate from ladder
 * - arena
 * - brawl
 *
 * XXX this is borderline ludicrous
 */
public class AbstractGameFormat {
  String formatName;

  public Game getGame() {
    Game game = new Game();
    return game;
  }
}
