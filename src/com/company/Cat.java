package com.company;

public class Cat implements Participant{
    private final String nickName;
    private final int fourLegsJumpHeight;
    private final int fourLegsRunLength;
    boolean isActive;

    public Cat (String nickName, int height, int length) {
        this.nickName = nickName;
        fourLegsJumpHeight = height;
        fourLegsRunLength = length;
        isActive = true;
    }
    public void toOvercome(Obstacle obj) {
        if(isActive) {
            if (obj instanceof Wall) { //если препятствие стена
                System.out.println("КОТЭ по кличке:" + nickName + " пытается преодолеть стену, высотой: " + obj.getRange());
                if (fourLegsJumpHeight >= obj.getRange()) {
                    System.out.println("КОТЭ по кличке:" + nickName + " перепрыгнул стену, высотой: " + obj.getRange());
                    isActive = true;
                } else {
                    System.out.println("КОТЭ по кличке: " + nickName + " не смог перепрыгнуть стену, высотой: " + obj.getRange() + ", так как может прыгнуть только на " + fourLegsJumpHeight);
                    isActive = false;
                }
            }
            if (obj instanceof Treadmill) { //если препятствие беговая дорожка
                System.out.println("КОТЭ по кличке:" + nickName + " пытается пробежать расстояние: " + obj.getRange());
                if (fourLegsRunLength >= obj.getRange()) {
                    System.out.println("КОТЭ по кличке:" + nickName + " пробежал расстояние: " + obj.getRange());
                    isActive = true;
                } else {
                    System.out.println("КОТЭ по кличке: " + nickName + "выбыл из соревнования. Не смог пробежать расстояние: " + obj.getRange() + ", так как может пробежать только " + fourLegsRunLength);
                    isActive = false;
                }
            }
        }
    }
    public String getName() {
        return nickName;
    }

}
