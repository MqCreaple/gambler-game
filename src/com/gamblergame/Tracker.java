package com.gamblergame;

import java.util.ArrayList;
import java.util.Collection;

public class Tracker {
    /**
     * For secure access of the tracker. Only the thread with tracker key can modify the content
     * of the tracker.
     */
    public static class TrackerKey {
        private Tracker tracker;

        public TrackerKey(int numPlayer) {
            this.tracker = new Tracker(numPlayer);
        }

        public Tracker getTracker() {
            return tracker;
        }

        public void add(Collection<? extends Integer> record) {
            assert(record.size() == tracker.numPlayer);
            tracker.history.addAll(record);
        }
    }

    private int numPlayer;
    private ArrayList<Integer> history;

    public Tracker(int numPlayer) {
        this.numPlayer = numPlayer;
        this.history = new ArrayList<>();
    }

    /**
     * Query the number a player submits in a given round
     * @param round the round to query (start from 0)
     * @param playerId the player ID to query (start from 0)
     */
    public int query(int round, int playerId) {
        return this.history.get(round * numPlayer + playerId);
    }

    public int getNumPlayer() {
        return numPlayer;
    }

    public int getNumRounds() {
        return history.size() / numPlayer;
    }
}
