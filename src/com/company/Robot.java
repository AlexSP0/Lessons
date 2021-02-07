package com.company;

public class Robot implements Participant {
    private final String robotId;
    private final int metalJumpHeight;
    private final int metalRunLength;
    boolean isActive;

    public Robot(String robotId, int height, int length) {
        this.robotId = robotId;
        metalJumpHeight = height;
        metalRunLength = length;
        isActive = true;
    }
    public void toOvercome(Obstacle obj) {
        if(isActive) {
            if (obj instanceof Wall) { //если препятствие стена
                System.out.println("КОТЭ по кличке:" + robotId + " пытается преодолеть стену, высотой: " + obj.getRange());
                if (metalJumpHeight >= obj.getRange()) {
                    System.out.println("КОТЭ по кличке:" + robotId + " перепрыгнул стену, высотой: " + obj.getRange());
                    isActive = true;
                } else {
                    System.out.println("КОТЭ по кличке: " + robotId + " не смог перепрыгнуть стену, высотой: " + obj.getRange() + ", так как может прыгнуть только на " + metalJumpHeight);
                    isActive = false;
                }
            }
            if (obj instanceof Treadmill) { //если препятствие беговая дорожка
                System.out.println("КОТЭ по кличке:" + robotId + " пытается пробежать расстояние: " + obj.getRange());
                if (metalRunLength >= obj.getRange()) {
                    System.out.println("КОТЭ по кличке:" + robotId + " пробежал расстояние: " + obj.getRange());
                    isActive = true;
                } else {
                    System.out.println("КОТЭ по кличке: " + robotId + "выбыл из соревнования. Не смог пробежать расстояние: " + obj.getRange() + ", так как может пробежать только " + metalRunLength);
                    isActive = false;
                }
            }
        }
    }

    public String getName() {
        return robotId;
    }

}
