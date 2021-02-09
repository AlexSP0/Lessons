package com.company;

//Класс СОРЕВНОВАТЕЛЬ, который в конструкторе принимает массив участников и массив препятствий

public class Competitor {
    private Participant[] participants;
    private ObstacleReal[] obstacles;

    public Competitor(Participant[] part, ObstacleReal[] obs) {
        this.participants = part;
        this.obstacles = obs;
    }
    public void startCompetition() { //Метод проведения соревнований путем перебора массива участников и препятствий
        for (int i = 0; i < participants.length; i++) { //перебор участников
            boolean flag = true;
            for (int j = 0; j < obstacles.length; j++) { //перебор массива препятствий для преодоления для конкретного участника
                    if(participants[i].isActive()) {
                        flag = overcome(participants[i], obstacles[j]); //метод для сравнения
                    } else { break;}
                    if(!flag) { participants[i].setActive(false); }
            }
        }
    }
    private boolean overcome(Participant part, ObstacleReal obs) { //метод определения, преодолел ли участник конкретное препятствие
        for (int i = 0; i < part.getObstacles().length; i++) {
            if(part.getObstacles()[i].getType() == obs.getType()) {
                //типы возможности и препятствия совпадают осталость проверить, хватит сил у участника преодолеть препятствие такого размера
                //System.out.println("У участника по имени: " + part.getName() + " есть возможность преодолеть препятствие: " + obs.getName());
                if (part.getObstacles()[i].getSize() >= obs.getSize()) {
                    //У участника хватает сил преодолеть это препятствие
                    System.out.println("Участник по имени: " + part.getName() + " " + part.getObstacles()[i].getSuccess() + " препятствие: " + obs.getName());
                    return true;
                } else {
                    //у участника не хватает сил преодолеть этот размер препятствия
                    //System.out.println("Участник по имени: " + part.getName() + " " + part.getObstacles()[i].getFailure() + " препятствие " + obs.getName());
                }
            } else {
                //типы возможностей и препятствия не совпадают, участник просто не умеет преодолевать такой тип препятствия
                //System.out.println("У участника по имени: " + part.getName() + " нет умения преодолевать препятствие: " + obs.getName());
            }
        }
        System.out.println("Эта хрень означает, что участник: " + part.getName()+" не смог преодолеть препятствие: " +obs.getName());
        return false;
    }
}
