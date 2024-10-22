package com.gamblergame;

import java.util.ArrayList;

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

        public void add(ArrayList<Integer> record) {
            assert(record.size() == tracker.numPlayer);
            tracker.tracker.addAll(record);
        }
    }

    private int numPlayer;
    private ArrayList<Integer> tracker;

    public Tracker(int numPlayer) {
        this.numPlayer = numPlayer;
        this.tracker = new ArrayList<>();
    }

    /**
     * Query the number a player submits in a given round
     * @param round the round to query (start from 0)
     * @param playerId the player ID to query (start from 0)
     */
    public int query(int round, int playerId) {
        return this.tracker.get(round * numPlayer + playerId);
    }

    public int getNumPlayer() {
        return numPlayer;
    }
}
