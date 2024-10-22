package com.gamblergame.strategies;

import com.gamblergame.Tracker;

import java.util.Arrays;

/**
 * Medium guess strategy: return the medium of last round's guesses.
 */
public class MediumGuessStrategy implements Strategy {
    private int defaultNum;

    public MediumGuessStrategy(int defaultNum) {
        this.defaultNum = defaultNum;
    }

    @Override
    public int strategy(Tracker tracker, int myId) {
        if(tracker.getNumRounds() == 0) {
            // If this is the first round, return the default guess
            return this.defaultNum;
        }
        // otherwise, get the medium of the last guesses
        int lastRoundIndex = tracker.getNumRounds() - 1;
        int numPlayer = tracker.getNumPlayer();
        int[] lastResults = new int[numPlayer];
        for(int i = 0; i < numPlayer; i++) {
            lastResults[i] = tracker.query(lastRoundIndex, i);
        }
        Arrays.sort(lastResults);
        if(numPlayer % 2 == 0) {
            int center = numPlayer / 2;
            return (lastResults[center - 1] + lastResults[center]) / 2;
        } else {
            return lastResults[numPlayer / 2];
        }
    }
}
