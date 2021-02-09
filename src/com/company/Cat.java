package com.company;
//все как у человека

public class Cat implements Participant{
    private boolean isActive;
    private ObstacleReal[] obstacles;
    String name;

    public Cat(String name, ObstacleReal[] obstacles) {
        this.name = name;
        this.obstacles = obstacles;
        isActive = true;
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setActive(boolean flag) {
        isActive = flag;
    }

    @Override
    public ObstacleReal[] getObstacles() {
        return obstacles;
    }
}
