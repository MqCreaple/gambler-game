package com.gamblergame.strategies;

import com.gamblergame.Tracker;

public class TestStrategy implements Strategy {
    @Override
    public int strategy(Tracker tracker) {
        return 42;
    }
}
