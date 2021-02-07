package com.company;


public class Main {

    public static void main(String[] args) {
        Participant[] part = new Participant[5];
        Obstacle[] obt = new Obstacle[5];

        part[0] = new Human("Александр", 2, 500);
        part[1] = new Human("Алексей", 2, 500);
        part[2] = new Cat("Байт", 4, 200);
        part[3] = new Robot("T-800", 10, 1000);
        part[4] = new Robot("T-9000", 12, 1200);

        obt[0] = new Wall(2);
        obt[1] = new Wall(8);
        obt[2] = new Treadmill(100);
        obt[3] = new Treadmill(250);
        obt[4] = new Wall(600);

        for (Participant p:
             part) {
            for (Obstacle obs:
                 obt) {
                    p.toOvercome(obs);
            }
        }

    }

}

