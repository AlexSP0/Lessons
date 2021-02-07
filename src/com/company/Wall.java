package com.company;

public class Wall implements Obstacle {
    private final int wallHeight;
    public Wall(int height) {
        wallHeight = height;
    }
    public int getRange() {
        return wallHeight;
    }
}
