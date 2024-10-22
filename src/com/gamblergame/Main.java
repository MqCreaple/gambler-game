package com.gamblergame;

import com.gamblergame.strategies.MediumGuessStrategy;
import com.gamblergame.strategies.SameNumberStrategy;
import com.gamblergame.strategies.Strategy;
import com.gamblergame.utils.IndexedInt;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Strategy[] strategies = new Strategy[] {
                new SameNumberStrategy(42),
                new SameNumberStrategy(43),
                new SameNumberStrategy(81),
                new MediumGuessStrategy(30),
        };
        int numRounds = 2;

        int[] score = new int[strategies.length];
        Tracker.TrackerKey key = new Tracker.TrackerKey(strategies.length);
        for(int rounds = 0; rounds < numRounds; rounds++) {
            // record the submission by each strategy
            IndexedInt[] records = new IndexedInt[strategies.length];
            for(int id = 0; id < records.length; id++) {
                records[id] = new IndexedInt(id, strategies[id].strategy(key.getTracker(), id));
            }
            Arrays.sort(records, Comparator.comparing(IndexedInt::getNumber));
            boolean hasRepetition = false;
            for(int i = 0; i < records.length - 1; i++) {
                if(records[i].number == records[i+1].number) {
                    // deduce points for repetition
                    hasRepetition = true;
                    int repetition = records[i].number;
                    for(; i < records.length && records[i].number == repetition; i++) {
                        score[records[i].index] -= 1;
                    }
                    i--;
                }
            }
            if(!hasRepetition) {
                // deduce the score of the maximum and minimum
                score[records[0].index] -= 1;
                for(int i = 1; i < records.length && records[i].number == records[i-1].number; i++) {
                    score[records[i].index] -= 1;
                }
                int largestIndex = records.length - 1;
                score[records[largestIndex].index]  -= 1;
                for(int i = largestIndex - 1; i >= 0 && records[i].number == records[i+1].number; i--) {
                    score[records[i].index] -= 1;
                }
            }
            // push the record into the tracker
            List<Integer> orderedRecord = new ArrayList<>(Collections.nCopies(records.length, 0));
            for(IndexedInt record : records) {
                orderedRecord.set(record.index, record.number);
            }
            key.add(orderedRecord);
            // print out the result at each round
            System.out.println("Round " + rounds + ": " + orderedRecord);
            System.out.println("Scores: " + Arrays.toString(score));
        }
    }
}