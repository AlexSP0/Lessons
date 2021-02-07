package com.company;

public class Treadmill implements Obstacle {
    private final int treadMillLength;
    public Treadmill (int length) {
        treadMillLength = length;
    }
    public int getRange() {
        return treadMillLength;
    }
}
