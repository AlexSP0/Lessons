package com.company;

//собственно класс препятствия-навыка преодоления препятствия

public class ObstacleReal implements Obstacle {
    private double  size; //содержит размер умения(препятствия), необходимый для этого препятствия
    private ObstacleEnum type; //возвращает тип умения(препятствия), необходмый для преодоления этого препятствия
    private String name; //Содержит текстовое название препятствия
    private String success; //содержит текст для печати в случае преодоления препятствия
    private String failure; //содержит текст для печати в случае невозможности преодолжения препятствия

    public ObstacleReal (double size, ObstacleEnum type, String name, String success, String failure) {
        this.size = size;
        this.type = type;
        this.name = name;
        this.success = success;
        this.failure = failure;
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public ObstacleEnum getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public String getSuccess() {
        return success;
    }

    public String getFailure() {
        return failure;
    }
}
