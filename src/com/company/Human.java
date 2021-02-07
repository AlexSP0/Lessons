package com.company;

public class Human implements Participant {
    private final String fullName;
    private final int jumpHeight;
    private final int runLength;
    boolean isActive;

    public Human(String name, int jumpHeight, int runLength) {
        fullName = name;
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
        isActive = true;
    }

    public void toOvercome(Obstacle obj) {
        if(isActive) {
            if (obj instanceof Wall) { //если препятствие стена
                System.out.println("Человек по имени:" + fullName + " пытается преодолеть стену, высотой: " + obj.getRange());
                if (jumpHeight >= obj.getRange()) {
                    System.out.println("Человек по имени:" + fullName + " перепрыгнул стену, высотой: " + obj.getRange());
                    isActive = true;
                } else {
                    System.out.println("Человек по имени: " + fullName + " не смог перепрыгнуть стену, высотой: " + obj.getRange() + ", так как может прыгнуть только на " + jumpHeight);
                    isActive = false;
                }
            }
            if (obj instanceof Treadmill) { //если препятствие беговая дорожка
                System.out.println("Человек по имени:" + fullName + " пытается пробежать расстояние: " + obj.getRange());
                if (runLength >= obj.getRange()) {
                    System.out.println("Человек по имени:" + fullName + " пробежал расстояние: " + obj.getRange());
                    isActive = true;
                } else {
                    System.out.println("Человек по имени: " + fullName + "выбыл из соревнования. Не смог пробежать расстояние: " + obj.getRange() + ", так как может пробежать только " + jumpHeight);
                    isActive = false;
                }
            }
        }
    }

    public String getName () {
        return fullName;
    }
}
