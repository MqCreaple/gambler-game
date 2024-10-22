package com.gamblergame.strategies;

import com.gamblergame.Tracker;

public interface Strategy {
    /**
     * The strategy to implement
     * @param tracker A tracker recording all the past rounds. You can check out the histories of each round with the `query` method.
     * @param myId Your ID in the record. Each player has a unique ID.
     * @return The number you submit in this round
     */
    int strategy(Tracker tracker, int myId);
}
