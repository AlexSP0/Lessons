package com.company;


public class Main {

    public static void main(String[] args) {
        ObstacleReal[] romanObs = new ObstacleReal[2]; //массив возможностей для человека по имени Роман
        romanObs[0] = new ObstacleReal(10, ObstacleEnum.WALL, "стена", "перепрыгнул", "не смог перепрыгнуть");
        romanObs[1] = new ObstacleReal(100, ObstacleEnum.TREADMILL, "беговая дорожка", "пробежал", "не смог пробежать");

        ObstacleReal[] pupsikObs = new ObstacleReal[2]; //массив возможностей кота по имени Пупсик
        pupsikObs[0] = new ObstacleReal(2, ObstacleEnum.WALL, "стена", "перепрыгнул", "не смог перепрыгнуть");
        pupsikObs[1] = new ObstacleReal(50, ObstacleEnum.TREADMILL, "беговая дорожка", "пробежад", "не смог пробежать");

        ObstacleReal[] t800 = new ObstacleReal[4]; //Массив возможностей робота Т-800
        t800[0] = new ObstacleReal(2, ObstacleEnum.WALL, "стена", "перепрыгнул", "не смог перепрыгнуть");
        t800[1] = new ObstacleReal(2000, ObstacleEnum.TREADMILL, "беговая дорожка", "пробежал", "не смог пробежать");
        t800[2] = new ObstacleReal(2000, ObstacleEnum.MAZE, "лабиринт", "прошел", "не не смог найти путь и не прошел");
        t800[3] = new ObstacleReal(2000, ObstacleEnum.trainerUTP86, "лабиринт", "прошел", "не не смог найти путь и не прошел");



        Participant[] part = new Participant[3]; //Массив участников соревнований
        part[0] = new Human("Роман", romanObs);
        part[1] = new Cat("Пупсик", pupsikObs);
        part[2] = new Robot("T-800", t800);

        ObstacleReal[] obstacleReals = new ObstacleReal[5]; //массив препятствий для соревнований
        obstacleReals[0] = new ObstacleReal(1,ObstacleEnum.WALL, "стена", "перепрыгнул", "не перепрыгнул");
        obstacleReals[1] = new ObstacleReal(70,ObstacleEnum.TREADMILL, "беговая дорожка", "пробежал", "не пробежал");
        obstacleReals[2] = new ObstacleReal(1000,ObstacleEnum.MAZE, "лабиринт", "прошел", "не смог найти путь и не прошел");
        obstacleReals[3] = new ObstacleReal(100,ObstacleEnum.trainerUTP86, "УТП-86", "перепрыгнул", "не перепрыгнул");
        obstacleReals[4] = new ObstacleReal(5,ObstacleEnum.WALL, "стена", "перепрыгнул", "не перепрыгнул");



        Competitor comp = new Competitor(part, obstacleReals);
        comp.startCompetition();
    }
}

