package com.company;

public class Human implements Participant{
    private boolean isActive; //флаг активности участника
    private ObstacleReal[] obstacles; //массив навыков и размера навыков для преодоления
    String name; //имя участника

    public Human(String name, ObstacleReal[] obstacles) {
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
