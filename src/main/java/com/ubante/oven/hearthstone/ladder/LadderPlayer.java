package com.ubante.oven.hearthstone.ladder;

import com.ubante.oven.hearthstone.common.Player;

import java.util.concurrent.BlockingQueue;

/**
 * This is dude that lurvs the ladder.
 */
public class LadderPlayer extends Player {

  public LadderPlayer(String s) {
    playerName = s;
  }

  public void setPlayerQueue(BlockingQueue<Player> pq) {
    playerQueue = pq;
  }
}
