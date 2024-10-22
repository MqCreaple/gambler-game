package com.gamblergame.strategies;

import com.gamblergame.Tracker;

public class SameNumberStrategy implements Strategy {
    private int number;

    public SameNumberStrategy(int number) {
        this.number = number;
    }

    @Override
    public int strategy(Tracker tracker, int myId) {
        return this.number;
    }
}
