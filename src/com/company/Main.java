package com.company;


public class Main {

    public static void main(String[] args) {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Шнурок", 10);
        cats[1] = new Cat("Бакс",15);
        cats[2] = new Cat("Еврик", 17);
        cats[3] = new Cat("Тугрик", 21);
        cats[4] = new Cat("Мышь",25);

        Plate plate = new Plate();
        plate.addFood(50);

        for (Cat num: cats) {
            num.eat(plate);
            num.isFullCat();
        }


    }

}

