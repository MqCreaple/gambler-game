package com.gamblergame;

import com.gamblergame.strategies.Strategy;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        Strategy[] strategies = new Strategy[] {};
        int numRounds = 100;

        int[] score = new int[strategies.length];
        Tracker.TrackerKey key = new Tracker.TrackerKey(strategies.length);
        for(int rounds = 0; rounds < numRounds; rounds++) {
            // TODO: implement game logic
        }
    }
}